package com.kolich.spray.service.routes

import akka.actor.Props
import spray.routing.HttpServiceActor

/**
  * Created by romeo on 7/11/2016.
  */
class Worker  extends HttpServiceActor {
  val webAppService = context.actorOf(Props[WebAppService])

  val restApi = context.actorOf(Props[ClientSideMVC])

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
