package com.kolich.spray.domain

import java.util.Date

/**
  * Created by romeo on 6/23/2016.
  */
class Theme(val id : Long, val name : String, var description : String, var color : String, var acceptanceCriteria : List[String], var createdBy : User, val createDate : Date) {

}
