package de.htwg.scalala.actors

import akka.actor._
import de.htwg.scalala.music._
import scala.language.postfixOps

class Composer extends Actor {

  val system = Director.system
  val Cellist = system.actorOf(Props(Musician(Cello)), name = "cellist")
  val Pianist = system.actorOf(Props(Musician(Piano)), name = "pianist")

  def receive = {
    case Start => {
      duet
    }
    case AddMusician(musician: ActorRef, instrument: Instrument) => {
      musician ! Play(Tune(c, e, g))
    }
  }

  def duet = {

    val voice1 = Tune(e2, e2, |, f2, e2, |, g, g, f, e, |, f2, e2)
    val voice2 = Tune(c, g, c, g, |, a, f, c, g, |, e, e, d, c, |, d, b, c2)
    Cellist ! Play(voice1)
    Pianist ! Play(voice2)

  }

}