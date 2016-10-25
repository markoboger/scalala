package de.htwg.scalala.music

import scala.language.postfixOps

object MusicWorksheet {

  val melody = List(d, d, d, c1)                  //> melody  : List[de.htwg.scalala.music.Key] = List(d, d, d, cᴕD)

 melody.play(Trumpet)                             //> res0: Seq[String] = List(d, d, d, cᴕD)
  Thread.sleep(800)

}