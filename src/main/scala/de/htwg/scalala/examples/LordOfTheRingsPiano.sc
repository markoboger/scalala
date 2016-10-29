package de.htwg.scalala.music

import de.htwg.scalala.players._
import scala.language.postfixOps
 
object LordOfTheRingsPiano {

  val LeftPiano = player(Piano, "LeftPiano")      //> akka.actor.InvalidActorNameException: actor name [LeftPiano] is not unique!
                                                  //| 	at akka.actor.dungeon.ChildrenContainer$NormalChildrenContainer.reserve(
                                                  //| ChildrenContainer.scala:129)
                                                  //| 	at akka.actor.dungeon.Children$class.reserveChild(Children.scala:130)
                                                  //| 	at akka.actor.ActorCell.reserveChild(ActorCell.scala:374)
                                                  //| 	at akka.actor.dungeon.Children$class.makeChild(Children.scala:268)
                                                  //| 	at akka.actor.dungeon.Children$class.attachChild(Children.scala:46)
                                                  //| 	at akka.actor.ActorCell.attachChild(ActorCell.scala:374)
                                                  //| 	at akka.actor.ActorSystemImpl.actorOf(ActorSystem.scala:579)
                                                  //| 	at akka.actor.TypedActorFactory$$anonfun$typedActorOf$2.apply(TypedActor
                                                  //| .scala:88)
                                                  //| 	at akka.actor.TypedActorFactory$$anonfun$typedActorOf$2.apply(TypedActor
                                                  //| .scala:88)
                                                  //| 	at akka.actor.TypedActorExtension.createActorRefProxy(TypedActor.scala:6
                                                  //| 79)
                                                  //| 	at akka.actor.TypedActorFactory$class.typedActorOf(TypedActor.scala:88)
                                                  //| 	at akka.actor.TypedActorExtension.typedActor
                                                  //| Output exceeds cutoff limit.-
  val RightPiano  = player(Piano, "RightPiano")
  var right = Line(d16, e16, fis, a, fis, e8, d2.dot, fis8, a8, Chord(d1, g1, b1), d8, c, a, Chord(a1-, d2, fis2))

  var left = Line(d-, a, d, a, d-, a, d, a, g, d, g, d, a)
  
  RightPiano.play(right)
  LeftPiano.play(left)
  DrumPlayer.play(c*Pattern(1,0,0,0)*4)
}