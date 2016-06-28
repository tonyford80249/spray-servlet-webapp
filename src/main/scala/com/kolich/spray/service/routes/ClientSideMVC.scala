package com.kolich.spray.service.routes

import java.util.Date

import com.kolich.spray.domain._
import com.kolich.spray.domain.types.{InProgress, OnePoint, Tier1}
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
        render("WEB-INF/ssp/main.ssp")
      }
    }  ~
      path("testuser") {
       get {
         complete {
           User("u454343", "Tony Ford")
         }
       }
     } ~
      path("testproject") {
        get {
          complete {
            val cs = new CoverStory(1, "WhyScrum", "Why do we need a Scrum Server",Map[String,String]("valueSystem" -> "You need a value system"), Map[String,String]("valueSystem" -> "/images/pic1.jpg"))
            val cs2 = new CoverStory(1, "The Purpose of OrderManagement", "Ordermanagement allows us to...",Map[String,String]("valueSystem" -> "You need a value system"), Map[String,String]("valueSystem" -> "/images/pic1.jpg"))
            val theme = new Theme(1, "Exception Logging", "The purpose of this requirement is to ensure all exceptions are logged", "blue", List[String]("All handled exception are logged"), User("james1", "James Brown"),  new Date)
            // String, override var description : String, var notes : String, var acceptanceCriteria : List[String], var themes : List[Theme], var pointing : StoryPoints, var rank : Int, var status : Status, var owner : User, var createdBy : User, val createDate : Date, var closeDate : Date
            val us = new UserStory(1,1,1,"createOrder","dec...","notes....", List[String]("use a webpage to create an order."), List[Theme](theme), new OnePoint, 1, new InProgress, User("james1", "James Brown"), User("james1", "James Brown"), new Date, new Date);
            val epic = new Epic(1,1,"OrderManagement","provide the ability to manage orders","notes...",cs2, List(us), 1, new Tier1, new InProgress, User("james1", "James Brown"), User("james1", "James Brown"), new Date, new Date)
            new Project(1, "ScrumServer", "custom project to build scrum software", "notes", cs, List[Epic](epic), 10, new Tier1, new InProgress, new  User("james1", "James Brown"), new  User("rule1", "JaRule"), new Date, new Date)
          }
        }
      } ~
      path("testcoverstory") {
        get {
          complete {
             new CoverStory(1, "WhyScrum", "Why do we need a Scrum Server",Map[String,String]("valueSystem" -> "You need a value system"), Map[String,String]("valueSystem" -> "/images/pic1.jpg"))
          }
        }
      } ~
      path("teststory") {
        get {
          complete {
            val theme = new Theme(1, "Exception Logging", "The purpose of this requirement is to ensure all exceptions are logged", "blue", List[String]("All handled exception are logged"), User("james1", "James Brown"),  new Date)

            new UserStory(1,1,1,"createOrder","dec...","notes....", List[String]("use a webpage to create an order."), List[Theme](theme), new OnePoint, 1, new InProgress, User("james1", "James Brown"), User("james1", "James Brown"), new Date, new Date);
          }
        }
      } ~
      path("testepic") {
        get {
          complete {
            val cs = new CoverStory(1, "WhyScrum", "Why do we need a Scrum Server",Map[String,String]("valueSystem" -> "You need a value system"), Map[String,String]("valueSystem" -> "/images/pic1.jpg"))

            val theme = new Theme(1, "Exception Logging", "The purpose of this requirement is to ensure all exceptions are logged", "blue", List[String]("All handled exception are logged"), User("james1", "James Brown"),  new Date)
            // String, override var description : String, var notes : String, var acceptanceCriteria : List[String], var themes : List[Theme], var pointing : StoryPoints, var rank : Int, var status : Status, var owner : User, var createdBy : User, val createDate : Date, var closeDate : Date
            val us = new UserStory(1,1,1,"createOrder","dec...","notes....", List[String]("use a webpage to create an order."), List[Theme](theme), new OnePoint, 1, new InProgress, User("james1", "James Brown"), User("james1", "James Brown"), new Date, new Date);

            new Epic(1,1,"OrderManagement","provide the ability to manage orders","notes...",cs, List(us), 1, new Tier1, new InProgress, User("james1", "James Brown"), User("james1", "James Brown"), new Date, new Date)
          }
        }
      } ~
      path("testtheme") {
        get {
          complete {
            new Theme(1, "Exception Logging", "The purpose of this requirement is to ensure all exceptions are logged", "blue", List[String]("All handled exception are logged"), User("james1", "James Brown"),  new Date)
          }
        }
      }
  }
}