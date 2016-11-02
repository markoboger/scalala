package de.htwg.scalala.players

import akka.actor._
import akka.actor.Scheduler
import scala.concurrent.duration._
import system.dispatcher
import scala.language.postfixOps
import de.htwg.scalala.music._

class Conductor extends Actor {
  var tickNum:Int=0
  val cancellable = system.scheduler.schedule(0 milliseconds, Context.tickduration, self, Tick(tickNum))
  var actors:List[ActorRef] = List()


  def receive = {
    case Start => println("Conductor Started")
    case Stop  => cancellable.cancel()
    case Add(player) => actors=player.actor::actors
    case Tick(tickNum) => actors.foreach(_! Tick(tickNum))
  }

}

