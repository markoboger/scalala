package de.htwg.scalala.music

import scala.language.postfixOps

object MusicWorksheet {

  val melody = List(d, d, d, c1)                  //> melody  : List[de.htwg.scalala.music.Key] = List(d, d, d, cᴕD)

  play(melody)                                    //> res0: List[String] = List(d, d, d, cᴕD)
  play( g, b, a)                                  //> res1: Seq[String] = ArrayBuffer(g, b, a)
  play((c, e, f))

  Context.midiPlayer.changeToInstrument(40, 0)
  play(melody)                                    //> res2: List[String] = List(d, d, d, cᴕD)

  Guitar.play(Chord(c, e, f))
  Guitar.play(d, f, b)                            //> res3: Seq[String] = ArrayBuffer(d, f, b)
  
  Thread.sleep(800)

}