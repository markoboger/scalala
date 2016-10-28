package de.htwg.scalala.music

import scala.language.postfixOps

object Herbstlied {
  val start = Line(c8, f.dot, a8, c.dot+, b8, a, g, f.dot)
  val middle = Line(p8, g8, g8, g8, b8, a, f8)
  val end = Line(p8, c+, d+, c8+, b8, a8, f8, a, g, f.dot)
  play(Track(start, middle , middle , end))
}
      