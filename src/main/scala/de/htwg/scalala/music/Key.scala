package de.htwg.scalala.music

case class Key(val midiNumber: Int, time: Double = Context.fraction, volume: Int = Context.volume) extends Music {
  require(0 <= midiNumber && midiNumber <= 128)
  require(0 <= volume && volume <= 100)

  def play: String = {
    Context.midiPlayer.play(key = midiNumber, duration = duration, volume)
    toString
  }
  def play(instrument: Instrument): String = {
    instrument.play(this)
    toString
  }

  val keynumber = midiNumber%12
  val octave = midiNumber/12 -1

  def duration = {
    val beatsPerMinute = Context.bpm
    val millisecondsInMinute = 1000 * 60
    val measureDuration = (millisecondsInMinute / beatsPerMinute) * 4
    (time * measureDuration).toInt
  }

  def sharp = Key(midiNumber + 1)
  def flat = Key(midiNumber - 1)
  def dot = copy(time=time*1.5)

  def speed(t: Double) = { copy(time = t) }

  def + = copy(midiNumber = midiNumber + 12)
  def ++ = copy(midiNumber = midiNumber + 24)
  def - = copy(midiNumber = midiNumber - 12)
  def -- = copy(midiNumber = midiNumber - 24)

  def soft = copy(volume = volume - Context.softDecrease)
  def ? = soft
  def hard = copy(volume = volume + Context.hardIncrease)
  def ! = hard

  def findChord(chordQuality: ChordQuality.Value): Chord = {
    chordQuality match {
      case ChordQuality.Major        => Chord(Set(this, majorTerz, majorQuint), name = toString.toUpperCase() + "maj")
      case ChordQuality.Minor        => Chord(Set(this, minorTerz, majorQuint), name = toString.toUpperCase() + "min")
      case ChordQuality.Diminshed    => Chord(Set(this, minorTerz, minorQuint), name = toString.toUpperCase() + "dim")
      case ChordQuality.Augmented    => Chord(Set(this, majorTerz, augmentedQuint), name = toString.toUpperCase() + "aug")
      case ChordQuality.Seventh      => Chord(Set(this, majorTerz, majorQuint, minorSetp), name = toString.toUpperCase() + "7")
      case ChordQuality.MajorSeventh => Chord(Set(this, majorTerz, majorQuint, majorSetp), name = toString.toUpperCase() + "maj7")
      case ChordQuality.MinorSeventh => Chord(Set(this, minorTerz, majorQuint, minorSetp), name = toString.toUpperCase() + "min7")
    }
  }
  def minorTerz = copy(midiNumber = this.midiNumber + 3)
  def majorTerz = copy(midiNumber = this.midiNumber + 4)
  def minorQuint = copy(midiNumber = this.midiNumber + 6)
  def majorQuint = copy(midiNumber = this.midiNumber + 7)
  def augmentedQuint = copy(midiNumber = this.midiNumber + 8)
  def minorSetp = copy(midiNumber = this.midiNumber + 10)
  def majorSetp = copy(midiNumber = this.midiNumber + 11)
  def maj: Chord = findChord(ChordQuality.Major)
  def dur: Chord = maj
  def min: Chord = findChord(ChordQuality.Minor)
  def mol: Chord = min
  def dim: Chord = findChord(ChordQuality.Diminshed)
  def aug: Chord = findChord(ChordQuality.Augmented)
  def maj7 = findChord(ChordQuality.MajorSeventh)
  def min7 = findChord(ChordQuality.MinorSeventh)
  
  val keynumberToString = Map(
    0 -> "c",
    1 -> "c\u266F",
    2 -> "d",
    3 -> "d\u266F",
    4 -> "e",
    5 -> "f",
    6 -> "f\u266F",
    7 -> "g",
    8 -> "g\u266F",
    9 -> "a",
    10 -> "a\u266F",
    11 -> "b")
  val octaveToString = Map(
    -1 -> ",,,,,",
    0 -> ",,,,",
    1 -> ",,,",
    2 -> ",,",
    3 -> ",",
    4 -> "",
    5 -> "'",
    6 -> "\"",
    7 -> "\"'",
    8 -> "\"\"",
    9 -> "\"\"'")
  val timeToString = Map(
    1.0 -> "\u1D15D",
    0.75 -> "\u00BD\u00B7",
    0.5 -> "\u00BD",
    0.375 -> "\u00B7",
    0.25 -> "",
    0.875 -> "1/8\u00B7",
    0.125 -> "1/8",
    0.09375 -> "1/16\u00B7",
    0.0625 -> "1/16",
    0.0 -> "|")

  override def toString = if (midiNumber==128) "| " else if (volume == 0) "-" else keynumberToString(keynumber) + octaveToString(octave) + timeToString(time)+" "
  override def equals(that: Any): Boolean =
    that match {
      case that: Key => (this.midiNumber == that.midiNumber) && (this.time == that.time)
      case _ => false
   }  
}

object Key {

}