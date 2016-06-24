package com.kolich.spray.domain

import java.util.Date

import com.kolich.spray.domain.types.{Status, StoryPoints}

/**
  * Created by romeo on 6/23/2016.
  */
class ShortStory(val projectId : Long, val epicId : Long, val id : Long,  val name : String, var description : String, var notes : String, var acceptanceCriteria : List[String], var themes : List[Theme], var pointing : StoryPoints, var rank : Int, var status : Status, var owner : User, var createdBy : User, val createDate : Date, var closeDate : Date) extends Story {

}
