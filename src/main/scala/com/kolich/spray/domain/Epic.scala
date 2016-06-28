package com.kolich.spray.domain

import java.util.Date

import com.kolich.spray.domain.types._

/**
  * Created by romeo on 6/23/2016.
  */
case class Epic(val projectId : Long, val id : Long, val name : String, var description : String, var notes : String, var coverStory : CoverStory, var stories : List[Story], var rank : Int, var tier : Tier, var status : Status, var owner : User, var createdBy : User, val createDate : Date, var closeDate : Date) {

}
