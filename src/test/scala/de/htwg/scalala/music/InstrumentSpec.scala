package de.htwg.scalala.music

import org.scalatest.WordSpec
import org.scalatest.Matchers
import scala.language.postfixOps

class InstrumentSpec extends WordSpec {
  
  "The most common Instruments" should {
    "readily be available if package music is imported" in {
      Piano.play(c16)
      Marimba.play(d16)
      Organ.play(e16)
      Guitar.play(f16)
      Bass.play(g16)
      Violin.play(a16)
      Cello.play(b16)
    }
    "be available on Key, Chord, List[Key], List[Chord]" in {
      c16.play(Piano)
      (d16.maj).play(Violin)
      List(e16, f16, g16).play(Cello)
      List(c16.dur, d16.mol, e16.mol, f.dur).play(Bass) 
    }
    
  }
  
}