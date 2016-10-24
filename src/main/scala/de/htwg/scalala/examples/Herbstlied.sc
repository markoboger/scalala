package de.htwg.scalala.music

import scala.language.postfixOps

object Herbstlied {
  val start = List(c8, f.dot, a8, c+.dot, b8, a, g, f.dot)
  val middle = List(p8, g8, g8, g8, b8, a, f8)
  val end = List(p8, c+, d+, c8+, b8, a8, f8, a, g, f.dot)
  play(start ++ middle ++ middle ++ end)
}
     