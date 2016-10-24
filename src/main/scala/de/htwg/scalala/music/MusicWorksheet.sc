package de.htwg.scalala.music

import scala.language.postfixOps

object MusicWorksheet {

  val melody = List(d, d, d, c1)                  //> melody  : List#8645[de#47.htwg#17819.scalala#17821.music#17827.Key#17836] = 
                                                  //| List(d, d, d, cᴕD)

 melody.play(Guitar)                              //> res0: Seq#3043[String#729597] = List(d, d, d, cᴕD)
  Thread.sleep(800)

}