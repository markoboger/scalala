package de.htwg.scalala.players

import akka.actor._
import de.htwg.scalala.music._

trait MusicMessage
case object Start extends MusicMessage
case class PlayNow(music:Music) extends MusicMessage

