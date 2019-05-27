//package de.htwg.scalala.music

import scala.language.postfixOps
import de.htwg.scalala.players._
import de.htwg.scalala.music._
import akka.actor._
object Quartett {

  Conductor ! Add(PianoPlayer)
  Conductor ! Add(DrumPlayer)
  Conductor ! Add(ViolinPlayer)
  Conductor ! Add(CelloPlayer)
  Conductor ! Start
  PianoPlayer.playAt(16,Tune(c16.mol * Pattern(1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1)))
                                                  //> Conductor Started-
  DrumPlayer.play(Tune(c16, c16, c8, c4, c2) * 6)
  ViolinPlayer.playAt(32,Tune(p4, f, e, p4) * 5)
  CelloPlayer.playAt(48, Tune(c2, e, p4) * 4)

}