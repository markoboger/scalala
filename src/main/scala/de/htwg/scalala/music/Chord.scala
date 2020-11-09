package de.htwg.scalala.music

case class Chord(
    set: Set[Key],
    repeat: Int = 1,
    pattern: Pattern = Pattern(1),
    ticks: Int = 4,
    volume:Int=Context.volume,
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
  def toTickList = (1 to repeat).toList.flatMap(x=> pattern.flatMap(part=>Some(this.copy(volume=volume*part))::((1 until ticks).toList.map(x=>None))))
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
