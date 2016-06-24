package com.kolich.spray.domain

/**
  * Created by romeo on 6/23/2016.
  */
object types {
  sealed trait Status

  class IsDefined extends Status
  class InProgress extends Status
  class InTesting extends Status
  class IsComplete extends Status
  class InAccepted extends Status
  class IsReleased extends Status
  class IsClosed extends Status
  class IsDead extends Status

  sealed trait Tier

  class Tier1 extends Tier
  class Tier2 extends Tier
  class Tier3 extends Tier

  abstract class StoryPoints(val points : Double, val description : String) {

  }

  class HalfPoint() extends StoryPoints(.5, "half a point")
  class OnePoint() extends StoryPoints(1, "half a point")
  class TwoPoints() extends StoryPoints(2, "two points")
  class ThreePoints() extends StoryPoints(3, "three points")
  class FivePoints() extends StoryPoints(5, "five points")
  class EightPoints() extends StoryPoints(8,"eight points")
  class Hugh() extends StoryPoints(13, "thirteen points or more")
}
