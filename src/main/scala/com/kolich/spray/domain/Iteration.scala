package com.kolich.spray.domain

import java.util.Date

import com.kolich.spray.domain.types.Status

/**
  * Created by romeo on 6/23/2016.
  */
class Iteration(val projectId : Long, var start : Date, var end : Date, var stories : List[Story], var status : Status) {

}
