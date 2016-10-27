package de.htwg.scalala.actors

import akka.actor._
import de.htwg.scalala.music._

case class MusicActor(instrument:Instrument) extends Actor {

  def receive = {

    case PlayNow(m:Music) => {
      println("starting to play")
      instrument.play(m)
    }
  }
}

trait MusicPlayer {
  def play(music: Music)
}

case class MusicPlayerImpl(musicActor: ActorRef) extends MusicPlayer {
  def play(music: Music): Unit = musicActor ! PlayNow(music)
}
