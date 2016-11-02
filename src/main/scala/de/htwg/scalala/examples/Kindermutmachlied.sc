package de.htwg.scalala.music

import scala.language.postfixOps

object Kindermutmachlied {
  val kindermutmachlied =  Line(c, |, f, f, g, g, |, a, a, f, f, |, d+, d+, c+, g, |, a2.dot, a,|, d+, d+, c+, g,|, a, a, f, c,|, d, f, g, g,|, f2, f8, c8+, bes8, a8,|, g, d.dot+, bes8, g8, f8,|, e, c.dot+, a8, g8, f8,|, e, f, g, c,|, f, g, a8, c8+, bes8, a8,|, g, d.dot+, bes8, a8, g8,|, f, c.dot+, a8, g8, f8,|, e, f, g, c,|, f2.dot, p2)
                                                  //> kindermutmachlied  : de#29.htwg#17819.scalala#17821.music#17827.Line#2680507
                                                  //| 7 = [c, |, f, f, g, g, |, a, a, f, f, |, d', d', c', g, |, a½·, a, |, d', 
                                                  //| d', c', g, |, a, a, f, c, |, d, f, g, g, |, f½, f1/8, c'1/8, a♯1/8, a1/8,
                                                  //|  |, g, d'·, a♯1/8, g1/8, f1/8, |, e, c'·, a1/8, g1/8, f1/8, |, e, f, g, 
                                                  //| c, |, f, g, a1/8, c'1/8, a♯1/8, a1/8, |, g, d'·, a♯1/8, a1/8, g1/8, |, 
                                                  //| f, c'·, a1/8, g1/8, f1/8, |, e, f, g, c, |, f½·, -]

  play(kindermutmachlied)
  kindermutmachlied.play(Guitar)
  
  println(kindermutmachlied.toString)             //> [c, |, f, f, g, g, |, a, a, f, f, |, d', d', c', g, |, a½·, a, |, d', d', 
                                                  //| c', g, |, a, a, f, c, |, d, f, g, g, |, f½, f1/8, c'1/8, a♯1/8, a1/8, |, 
                                                  //| g, d'·, a♯1/8, g1/8, f1/8, |, e, c'·, a1/8, g1/8, f1/8, |, e, f, g, c, |
                                                  //| , f, g, a1/8, c'1/8, a♯1/8, a1/8, |, g, d'·, a♯1/8, a1/8, g1/8, |, f, c
                                                  //| '·, a1/8, g1/8, f1/8, |, e, f, g, c, |, f½·, -]
     
}