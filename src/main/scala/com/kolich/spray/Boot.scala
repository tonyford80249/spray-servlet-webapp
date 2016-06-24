/**
 * Copyright (c) 2013 Mark S. Kolich
 * http://mark.koli.ch
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package com.kolich.spray



import com.kolich.spray.service._
import com.kolich.spray.service.routes._

import akka.actor._
import akka.routing._
import com.typesafe.scalalogging.LazyLogging
import spray.servlet._
import spray.routing._
import org.fusesource.scalate.TemplateEngine
import java.io.File


class Boot extends WebBoot with LazyLogging  {

  val system = ActorSystem("spray-servlet-webapp")

  val webAppService = system.actorOf(Props[WebAppService])

  val restApi = system.actorOf(Props[ClientSideMVC])

  
  class RootServiceActor extends HttpServiceActor {
    override def receive = runRoute {
       pathPrefix("api") {
         restApi ! _
       } ~ {
    	  // Any other request that does not start with "api" is
    	  // sent here, the generic web-app service.
    	  webAppService ! _
      }
    }
  }

//  class ServiceProxy extends Actor {
//    val endpoint = context.actorOf(Props(new RootServiceActor))
//
//    def receive = {
//      case x => endpoint forward x
//    }
//  }

  class RootServiceRouter  extends Actor {
    val resizer = DefaultResizer(lowerBound = 2, upperBound = 15)

    //val router: ActorRef = context.actorOf(RoundRobinPool(5, Some(resizer)).props(Props[ServiceProxy]),"router")
    //val router: ActorRef = context.actorOf(Props(new RootServiceActor).withRouter(RoundRobinPool(5)), name = "router")
    var router = {
      val routees = Vector.fill(5) {
        val r = context.actorOf(Props(new RootServiceActor))
        context watch r

        ActorRefRoutee(r)
      }

      Router(RoundRobinRoutingLogic(), routees)
    }


    def receive = {
      case x => router.route(x, sender())
    }
  }

  val serviceActor = system.actorOf(Props(new RootServiceRouter))
  
  system.registerOnTermination {
	  logger.info("Root actor system shutting down...")
	  system.shutdown
  }
  
}
