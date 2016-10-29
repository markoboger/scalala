package de.htwg.scalala.music

import de.htwg.scalala.midi.MidiPlayer

case class Chord(
    set: Set[Key],
    repeat: Int = 1,
    pattern: Pattern = Pattern(1),
    time: Double = 0.25,
    name: String = "") extends MusicElem {
  def play(instrument: Instrument = Piano, volume: Int): Unit = for (i <- 1 to repeat; part <- pattern) {
    instrument.midiPlayer.play(set, volume=volume*part)
  }
  def *(_pattern: Pattern): Chord = copy(pattern = _pattern)
  def *(repetitions: Int): Chord = copy(repeat = repetitions)
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
