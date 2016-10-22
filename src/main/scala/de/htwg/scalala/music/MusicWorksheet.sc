package de.htwg.scalala.music

import player._
import notes._
import chords._
 
import scala.language.postfixOps
 
  
object MusicWorksheet {

  val key1 = Key(0, 4)                            //> key1  : de.htwg.scalala.music.Key = c
  val key2 = Key(12,3)                            //> key2  : de.htwg.scalala.music.Key = c,
  val key3 = Key(24,2)                            //> key3  : de.htwg.scalala.music.Key = c,,
   
  val chord1 =  Chord(Set(c,d,e))                 //> chord1  : de.htwg.scalala.music.Chord = [()]
  val chord2 = Chord(f,g, a , c+, e+)             //> chord2  : de.htwg.scalala.music.Chord = [()]
  val Cmaj = Chord(c, ChordQuality.Major)         //> Cmaj  : de.htwg.scalala.music.Chord = Cmaj
  val Dmaj = Chord(d, ChordQuality.Major)         //> Dmaj  : de.htwg.scalala.music.Chord = Dmaj
  val Emaj = Chord(e, ChordQuality.Major)         //> Emaj  : de.htwg.scalala.music.Chord = Emaj
  val Fmaj = Chord(f, ChordQuality.Major)         //> Fmaj  : de.htwg.scalala.music.Chord = Fmaj
  
  val Cmaj2:Chord = c.maj                         //> Cmaj2  : de.htwg.scalala.music.Chord = Cmaj
  val Dmaj2= d.maj                                //> Dmaj2  : de.htwg.scalala.music.Chord = Dmaj
   
  (c.maj).play
  play(List(c.maj, d.maj))                        //> res0: <error> = ()
  
    val charmony = List(c.dur, d.mol, e.mol, f.dur, g.dur, a.mol, b.dim)
                                                  //> charmony  : List[de.htwg.scalala.music.Chord] = List(Cmaj, Dmin, Emin, Fmaj,
                                                  //|  Gmaj, Amin, Bdim)
    
    play(charmony)                                //> res1: <error> = ()
  
  
}