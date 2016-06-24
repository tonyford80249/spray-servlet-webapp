package com.kolich.spray.domain

import java.util.Date

import com.kolich.spray.domain.types.Status

/**
  * Created by romeo on 6/23/2016.
  */
case class Release(val projectId : Long, var releaseDate : Date, var coverStory : CoverStory, var stories : List[Story], var status : Status) {

}
