package de.htwg.scalala.music

import scala.language.postfixOps
import de.htwg.scalala.players._
import akka.actor._

object MusicWorksheet {

 
  Conductor ! Add(PianoPlayer)
  Conductor ! Add(DrumPlayer)
  Conductor ! Add(ViolinPlayer)
  Conductor ! Start
    PianoPlayer.play(Tune(c16.mol*Pattern(1,0,1,0,1,1,0,0,1,1,1,1,1,0,0,1) ))
                                                  //> Conductor Started
                                                  //| [ERROR] [11/01/2016 18:03:21.269] [Orchestra-akka.actor.default-dispatcher-2
                                                  //| ] [akka://Orchestra/user/ViolinActor] tail of empty list
                                                  //| java.lang.UnsupportedOperationException: tail of empty list
                                                  //| 	at scala.collection.immutable.Nil$.tail(List.scala:422)
                                                  //| 	at scala.collection.immutable.Nil$.tail(List.scala:417)
                                                  //| 	at de.htwg.scalala.players.MusicActor.playNextKey(MusicPlayer.scala:28)
                                                  //| 	at de.htwg.scalala.players.MusicActor$$anonfun$receive$1.applyOrElse(Mus
                                                  //| icPlayer.scala:14)
                                                  //| 	at akka.actor.Actor$class.aroundReceive(Actor.scala:484)
                                                  //| 	at de.htwg.scalala.players.MusicActor.aroundReceive(MusicPlayer.scala:10
                                                  //| )
                                                  //| 	at akka.actor.ActorCell.receiveMessage(ActorCell.scala:526)
                                                  //| 	at akka.actor.ActorCell.invoke(ActorCell.scala:495)
                                                  //| 	at akka.dispatch.Mailbox.processMailbox(Mailbox.scala:257)
                                                  //| 	at akka.dispatch.Mailbox.run(Mailbox.scala:224)
                                                  //| 	at akka.dispatch.Mailbox.exec(Mailbox.scala:234)
                                                  //| 	at scala.concurrent.forkjoin
                                                  //| Output exceeds cutoff limit.\
                                                
    
 //    DrumPlayer.play(Tune(c16, c16, c8, c4,c2 )*4)
   
//     ViolinPlayer.play(Tune(p4, f, e, p4)*4)
  
 // Thread.sleep(12000)

 // Conductor ! Stop
}