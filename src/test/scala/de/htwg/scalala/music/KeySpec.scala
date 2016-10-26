package de.htwg.scalala.music

import org.scalatest.WordSpec
import org.scalatest.Matchers
import scala.language.postfixOps

class KeySpec extends WordSpec with Matchers {

  "Keys" should {
    "be easy to create from the REPL" in {
      val key1 = Key(60)
      val key4 = Key(midiNumber = 60, time = 0.25)
      val key5 = Key(midiNumber = 60, time = 0.25, volume = 75)
    }
    "should have a sharp and a flat variant" in {
      c.sharp should be(cis)
      c.flat should be(ces)
    }
    "should have a louder and a less loud variant" in {
      (c!).volume should be > c.volume
      (c?).volume should be < c.volume
    }
    "should have different times ( 1/2, 1/4, 1/8, 1/16)" in {
      c1 should be(Key(60, time = 1))
      c2 should be(Key(60, time = 0.5))
      c4 should be(Key(60, time = 0.25))
      c8 should be(Key(60, time = 0.125))
      c16 should be(Key(60, time = 0.0625))
    }
    "should be equal if key and time are equal" in {
      Key(60) should be(Key(60))
      Key(60).octave should be(Key(60).octave)
    }
    "should have a midiNumber" in {
      Key(60).midiNumber should be(60)
      Key(60).keynumber should be(0)
    }
    "should be easy to convert to the same key in the next or lower octave" in {
      (c+).midiNumber should be(Key(72).midiNumber)
      (c-).midiNumber should be(Key(48).midiNumber)
      (c++).midiNumber should be(Key(84).midiNumber)
      (c--).midiNumber should be(Key(36).midiNumber)
    }
    "should have a concise and clear text representation" in {
      c.toString should be("c ")
      cis.toString should be("c\u266F " )
      c2.toString should be("c\u00BD")
      Key(60 + 12 * 5).toString should be("c\"\"'")
      (c++).toString should be("c\"")
      (c+).toString should be("c'")
      (c).toString should be("c")
      (c-).toString should be("c,")
      (c--).toString should be("c,,")
    }
    "should have minor and major terz" in {
      c.majorTerz should be(e)
      c.minorTerz should be(dis)
    }
    "should have minor and major quint" in {
      c.majorQuint should be(g)
      c.minorQuint should be(ges)
    }
    "should have chords in major and minor" in {
      c.maj should be(Chord(c, e, g))
      c.min should be(Chord(c, dis, g))
      c.dur should be(c.maj)
      c.mol should be(c.min)
    }
  }
  "Default Keys" should {
    "readily be available in the REPL or Worksheet if the package music is imported" in {
      c should be(Key(60))
      cis should be(Key(61))
      d should be(Key(62))
    }
    "return a String showing the key" in {
      c16.toString() should be("c1/16")
    }
  }
  "Playing a Key" should {
    "be possible from the REPL or Worksheet" in {
      c16.play
    }
    "should also be possible on the Key" in {
      c16.play
    }
    "should be possible on an instrument" in {
      c16.play(Guitar)
    }
  }
  "Playing a Line of Keys" should {
    val melody = Line(g16, e16, e8, f16, d16, d8)
    "be possible from the REPL or Worksheet" in {
      play(melody)
    }
    "should also be possible on the List" in {
      melody.play
    }
    "should be possible on an instrument" in {
      melody.play(Guitar)
    }
  }
}