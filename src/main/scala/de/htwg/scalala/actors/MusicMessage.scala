package de.htwg.scalala.actors

import akka.actor._
import de.htwg.scalala.music._

trait MusicMessage
case object Start extends MusicMessage
case class AddMusician(musician:ActorRef, instrument:Instrument) extends MusicMessage
case class Play(music:Music) extends MusicMessage

