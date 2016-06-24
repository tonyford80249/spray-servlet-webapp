package com.kolich.spray.service.routes

import com.kolich.spray.domain.User
import com.kolich.spray.service.Service
import com.kolich.spray.templating.ScalateSupport
import com.kolich.spray.json.ProjectJsonSupport._

/**
  * Created by romeo on 6/22/2016.
  */
class ClientSideMVC  extends Service with ScalateSupport {

  override def receive = runRoute {
    path("main") {
      get {
        render("templates/main.ssp")
      }
    }  ~
      path("testuser") {
       get {
         complete {
           User("u454343", "Tony Ford")
         }
       }
     }
  }
}