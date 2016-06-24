package com.kolich.spray.json

import spray.json._
import spray.httpx.SprayJsonSupport
import com.kolich.spray.domain._
;
import com.kolich.spray.domain.types._


/**
  * Created by romeo on 6/23/2016.
  */
object ProjectJsonSupport extends DefaultJsonProtocol with SprayJsonSupport {
  implicit object MyTierJsonFormat extends JsonFormat[com.kolich.spray.domain.types.Tier] {
    def write(x: Tier) = JsString(x match { case i:Tier1 => "tier1" case i:Tier2 => "tier2" case i:Tier3 => "tier3"})
    def read(value: JsValue) : Tier = DefaultJsonProtocol.StringJsonFormat.read(value) match { case "tier1" => new Tier1 case "tier2" => new Tier2 case "tier3" => new Tier3}
  }

  implicit object MyStatusJsonFormat extends JsonFormat[com.kolich.spray.domain.types.Status] {
    def write(x: Status) = JsString(x match { case i:IsDefined => "IsDefined" case i:InProgress => "InProgress" case i:InTesting => "InTesting" case i:IsComplete => "IsComplete" case i:InAccepted => "InAccepted" case i:IsReleased => "IsReleased" case i:IsClosed => "IsClosed" case i:IsDead => "IsDead"})
    def read(value: JsValue) : Status = DefaultJsonProtocol.StringJsonFormat.read(value) match { case "IsDefined" => new IsDefined case "InProgress" => new InProgress case "InTesting" => new InTesting  case "IsComplete" => new IsComplete case "InAccepted" => new InAccepted  case "IsReleased" => new IsReleased case "IsClosed" => new IsClosed}
  }

  implicit object MyStoryPointsJsonFormat extends JsonFormat[com.kolich.spray.domain.types.StoryPoints] {
    def write(x: StoryPoints) = JsString(x match { case i:HalfPoint => "HalfPoint" case i:OnePoint => "OnePoint" case i:TwoPoints => "TwoPoints" case i:ThreePoints => "ThreePoints" case i:FivePoints => "FivePoints" case i:EightPoints => "EightPoints" case i:Hugh => "Hugh"})
    def read(value: JsValue) : StoryPoints = DefaultJsonProtocol.StringJsonFormat.read(value) match { case "HalfPoint" => new HalfPoint case "OnePoint" => new OnePoint case "TwoPoints" => new TwoPoints case "ThreePoints" => new ThreePoints case "FivePoints" => new FivePoints case "EightPoints" => new EightPoints}
  }

  implicit object MyDateJsonFormat extends JsonFormat[java.util.Date] {
    def write(x: java.util.Date) = JsNumber(if (x != null) x.getTime else System.currentTimeMillis)
    def read(value: JsValue) = new java.util.Date(DefaultJsonProtocol.LongJsonFormat.read(value))
  }

  implicit object AnimalJsonFormat extends RootJsonFormat[Story] {
    def write(a: Story) = a match {
      case p: UserStory => p.toJson
      case p: ShortStory => p.toJson
    }
    def read(value: JsValue) =
    // If you need to read, you will need something in the
    // JSON that will tell you which subclass to use
      value.asJsObject.fields("kind") match {
        case JsString("userstory") => value.convertTo[UserStory]
        case JsString("shortstory") => value.convertTo[ShortStory]
      }
  }


  implicit val projectFormats9 = jsonFormat2(User)

  implicit val projectFormats3 = jsonFormat7(Theme)

  implicit val projectFormats2 = jsonFormat5(CoverStory)

  implicit val projectFormats8 = jsonFormat5(Release)

  implicit val projectFormats7 = jsonFormat5(Iteration)

  implicit val projectFormats6 = jsonFormat14(Epic)

  implicit val projectFormats5 = jsonFormat15(ShortStory)

  implicit val projectFormats4 = jsonFormat15(UserStory)

  implicit val projectFormats = jsonFormat13(Project)



}
