package de.htwg.scalala.players

import akka.actor._
import akka.actor.Scheduler
import scala.concurrent.duration._
import system.dispatcher
import scala.language.postfixOps
import de.htwg.scalala.music._

class Conductor extends Actor {

  val cancellable = system.scheduler.schedule(0 milliseconds, Context.tickduration, self, Tick)
  var actors:List[ActorRef] = List()

  def receive = {
    case Start => println("Conductor Started")
    case Stop  => cancellable.cancel()
    case Add(player) => actors=player.actor::actors
    case Tick => actors.foreach(_! Tick)
  }

}

