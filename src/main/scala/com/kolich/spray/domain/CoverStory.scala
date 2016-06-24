package com.kolich.spray.domain

/**
  * Created by romeo on 6/23/2016.
  */
case class CoverStory(val id : Long, var name : String, var description : String, var headlines : Map[String,String], images : Map[String,String]) {

}
