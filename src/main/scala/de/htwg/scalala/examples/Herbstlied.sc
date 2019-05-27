//package de.htwg.scalala.music

import de.htwg.scalala.music._
import de.htwg.scalala.players._
import scala.language.postfixOps

object Herbstlied {
  val start = Line(c8, f.dot, a8, c.dot+, b8, a, g, f.dot)
                                                  //> start  : de#29.htwg#17819.scalala#17821.music#17827.Line#26805077 = [c1/8, f
                                                  //| ·, a1/8, c'·, b1/8, a, g, f·]
  val middle = Line(p8, g8, g8, g8, b8, a, f8)    //> middle  : de#29.htwg#17819.scalala#17821.music#17827.Line#26805077 = [-, g1/
                                                  //| 8, g1/8, g1/8, b1/8, a, f1/8]
  val end = Line(p8, c+, d+, c8+, b8, a8, f8, a, g, f.dot)
                                                  //> end  : de#29.htwg#17819.scalala#17821.music#17827.Line#26805077 = [-, c', d'
                                                  //| , c'1/8, b1/8, a1/8, f1/8, a, g, f·]/
  play(Track(start, middle , middle , end))
}
      