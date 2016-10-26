package de.htwg.scalala.music

import scala.language.postfixOps

object MusicWorksheet {
 
val c7=Chord(f, a, b)                             //> c7  : de.htwg.scalala.music.Chord = [()]
 val t = Tune(d.mol,g, c7)                        //> t  : de.htwg.scalala.music.Tune = (Dmin, g, [()])
 val l =Line(t, t)                                //> l  : de.htwg.scalala.music.Line = [(Dmin, g, [(]]], (Dmin, g, [(]]]]/
 play(t)
  
   
     
  Thread.sleep(800)

}