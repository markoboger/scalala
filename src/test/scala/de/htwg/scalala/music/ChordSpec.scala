package de.htwg.scalala.music

import org.scalatest.WordSpec
import org.scalatest.Matchers
import scala.language.postfixOps

class ChordSpec extends WordSpec with Matchers {

  "A Chord" should {
    "be easy to create" in {
      Chord(c, e, g)
      Chord(c, e, g, ais)
      (c, e, g)
      (c, e, g, ais)
      c.maj
    }
    "have a concise String representation for all well known chords" in {
      c.maj.toString should be("Cmaj")
    }
  }
  "Playing a Chord" should {
    "be easy from the REPL or Worksheet" in {
      play(c16.maj)
    }
    "should also be possible on the Chord" in {
      c16.maj.play()
    }
  }

}