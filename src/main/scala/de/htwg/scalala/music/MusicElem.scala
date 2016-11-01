package de.htwg.scalala.music

import scala.concurrent.duration._
import scala.language.postfixOps

trait MusicElem extends Music {
  val ticks:Int
  def duration =  ticks * Context.tickduration
}