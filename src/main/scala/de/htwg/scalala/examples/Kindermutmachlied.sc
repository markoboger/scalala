package de.htwg.scalala.music

import scala.language.postfixOps

object Kindermutmachlied {
  val kindermutmachlied =  Line(c, |, f, f, g, g, |, a, a, f, f, |, d+, d+, c+, g, |, a2.dot, a,|, d+, d+, c+, g,|, a, a, f, c,|, d, f, g, g,|, f2, f8, c8+, bes8, a8,|, g, d.dot+, bes8, g8, f8,|, e, c.dot+, a8, g8, f8,|, e, f, g, c,|, f, g, a8, c8+, bes8, a8,|, g, d.dot+, bes8, a8, g8,|, f, c.dot+, a8, g8, f8,|, e, f, g, c,|, f2.dot, p2)

  play(kindermutmachlied)
  println(kindermutmachlied.toString   )
    
}