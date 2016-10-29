package de.htwg.scalala.players

import akka.actor._

class Conductor extends Actor {

  def receive = {
    case Start => println("starting to send ticks")
  }

}

