package de.htwg.scalala.examples

import de.htwg.scalala.music._
import de.htwg.scalala.players._
import scala.language.postfixOps


object Duet {
	Conductor!Add(PianoPlayer)
	Conductor!Add(CelloPlayer)
	Conductor!Start                           //> Conductor Started
  val voice1 = Tune(e2, e2, |, f2, e2, |, g, g, f, e, |, f2, e2)
                                                  //> voice1  : de#29.htwg#17819.scalala#17821.music#17827.Tune#26805074 = (e½, e
                                                  //| ½, |, f½, e½, |, g, g, f, e, |, f½, e½)
  val voice2 = Tune(c, g, c, g, |, a, f, c, g, |, e, e, d, c, |, d, b, c2)
                                                  //> voice2  : de#29.htwg#17819.scalala#17821.music#17827.Tune#26805074 = (c, g, 
                                                  //| c, g, |, a, f, c, g, |, e, e, d, c, |, d, b, c½)|
  PianoPlayer.play(voice1)
  CelloPlayer.play(voice2)
}