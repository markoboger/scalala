package de.htwg.scalala.midi

import de.htwg.scalala.music.Key

import org.scalatest.WordSpec
import org.scalatest.Matchers
import scala.language.postfixOps
import de.htwg.scalala.music._

class MidiPlayerSpec extends WordSpec {

  "A MidiPlayer" should {
    val midiplayer = new MidiPlayer

    "play Keys encoded in midiKeys (0-127, c is key 60) for a duration in milliseconds" in {
      midiplayer.play(key = 60, duration = 100)
      Thread.sleep(100)
    }
    "play a set of Keys simultaneously, needed for chords" in {
      val set = Set(new Key(60), new Key(64), new Key(67))
      midiplayer.play(set, 75)
    }
    "start and stop a key with some delay inbetween. This is needed to play several keys at once." in {
      midiplayer.start(60)
      Thread.sleep(100)
      midiplayer.stop(60)
    }
    "be able to change instrument" in {
      midiplayer.changeToInstrument(40)
      midiplayer.play(60, 100)
      Thread.sleep(200)
    }
    
  }

}