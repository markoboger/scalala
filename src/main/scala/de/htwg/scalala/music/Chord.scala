package de.htwg.scalala.music

case class Chord(set: Set[Key], name: String = "") extends Music {
  def play: Unit = Context.midiPlayer.play(set)
  override def toString = if (name == "") "[" + set.foreach(_.toString) + "]" else name
  def asLy = toString
  def asDSL = toString
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
    rootkey.findChord(chordQuality)
  }
}

object ChordQuality extends Enumeration {
  type ChordQuality = Value
  val Major, Minor, Diminshed, Augmented, Seventh, MajorSeventh, MinorSeventh = Value
}
