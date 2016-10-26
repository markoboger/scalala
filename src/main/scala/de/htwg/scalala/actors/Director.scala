package de.htwg.scalala.actors

import akka.actor._
import de.htwg.scalala.music._

object Director extends App {
  
    val system = ActorSystem("Orchestra")
    val conductor = system.actorOf(Props[Conductor], name = "conductor")
    val composer = system.actorOf(Props[Composer], name = "composer")
 
    println("Setting up Orchestra")
    conductor!Start
    composer!Start
    println("Sent out messages")
  
  
}