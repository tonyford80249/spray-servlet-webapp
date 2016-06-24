package com.kolich.spray.json

import spray.json.DefaultJsonProtocol
import spray.httpx.SprayJsonSupport
import spray.json.JsonFormat
import spray.json.JsNumber
import spray.json.JsString
import spray.json.JsValue
import com.kolich.spray.domain.Project;
import com.kolich.spray.domain.types.Tier
import com.kolich.spray.domain.types.Tier1
import com.kolich.spray.domain.types.Tier2
import com.kolich.spray.domain.types.Tier3


/**
  * Created by romeo on 6/23/2016.
  */
object ProjectJsonSupport extends DefaultJsonProtocol with SprayJsonSupport {
  implicit object MyTierJsonFormat extends JsonFormat[com.kolich.spray.domain.types.Tier] {
    def write(x: Tier) = JsString(x match { case i:Tier1 => "tier1" case i:Tier2 => "tier2" case i:Tier3 => "tier3"})
    def read(value: JsValue) : Tier = DefaultJsonProtocol.StringJsonFormat.read(value) match { case "tier1" => new Tier1 case "tier2" => new Tier2 case "tier3" => new Tier3}
  }

  implicit object MyDateJsonFormat extends JsonFormat[java.util.Date] {
    def write(x: java.util.Date) = JsNumber(if (x != null) x.getTime else System.currentTimeMillis)
    def read(value: JsValue) = new java.util.Date(DefaultJsonProtocol.LongJsonFormat.read(value))
  }

  implicit val projectFormats = jsonFormat13(Project)
}
