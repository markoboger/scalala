package de.htwg.scalala.music

import scala.language.postfixOps

object MusicWorksheet {

  val melody = List(d, d, d, c1)                  //> melody  : List#8647[de#29.htwg#17821.scalala#17823.music#17829.Key#17872] = 
                                                  //| List(d, d, d, cᴕD)

 melody.play(Guitar)                              //> res0: Seq#3045[String#3909288] = List(d, d, d, cᴕD)
  Thread.sleep(800)

}