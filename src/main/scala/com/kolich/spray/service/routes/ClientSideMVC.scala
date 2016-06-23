package com.kolich.spray.service.routes

import com.kolich.spray.service.Service
import com.kolich.spray.templating.ScalateSupport


/**
  * Created by romeo on 6/22/2016.
  */
class ClientSideMVC  extends Service with ScalateSupport {

  override def receive = runRoute {
    path("main") {
      get {
        render("WEB-INF/ssp/main.ssp")
      }
    }
  }
}