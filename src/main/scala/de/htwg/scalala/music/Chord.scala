package de.htwg.scalala.music

import de.htwg.scalala.midi.MidiPlayer

case class Chord(set: Set[Key], time:Double = 0.25, name: String = "") extends MusicElem {
  def play(instrument:Instrument=Piano): Unit = instrument.midiPlayer.play(set)
  override def toString = if (name == "") "[" + set.foreach(_.toString) + "]" else name
  override def equals(that: Any): Boolean =
    that match {
      case that: Chord => (this.set == that.set)
      case _           => false
    }
}

object Chord {

  def apply(keys: Key*): Chord = {
    Chord(keys.toSet)
  }

  def apply(rootkey: Key, chordQuality: ChordQuality.Value): Chord = {
    rootkey.chord(chordQuality)
  }
}

object ChordQuality extends Enumeration {
  type ChordQuality = Value
  val Major, Minor, Diminshed, Augmented, Seventh, MajorSeventh, MinorSeventh = Value
}
