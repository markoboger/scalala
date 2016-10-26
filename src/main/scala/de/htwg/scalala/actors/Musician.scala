package de.htwg.scalala.actors

import akka.actor._
import de.htwg.scalala.music._

case class Musician(instrument:Instrument) extends Actor {

  def receive = {

    case play(m:Music) => {
      println("starting to play")
      instrument.play(m)
    }
  }

}

case class SetInstrument(instrument: Instrument) extends MusicMessage