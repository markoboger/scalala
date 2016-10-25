package de.htwg.scalala.music

case class Chord(set: Set[Key], time:Double = 0.25, name: String = "") extends MusicElem {
  def play: Unit = Context.midiPlayer.play(set)
  def play(instrument:Instrument): Unit = instrument.play(this) 
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
