package de.htwg.scalala.actors

import akka.actor._

class Conductor extends Actor {

  def receive = {
    case Start => println("starting to send ticks")
  }

}

