package de.htwg.scalala.music

case class Key(var keynumber: Int, var octave: Int = Context.octave, time: Double = Context.fraction, volume: Int = Context.volume) extends Music {
  if (keynumber >= 12) {
    keynumber = keynumber % 12
    octave = octave + keynumber / 12
  }
  if (keynumber < 0) {
    keynumber = (12 + keynumber) % 12
    octave = octave - 1
  }
  require(0 <= keynumber && keynumber < 12)
  require(-1 <= octave && octave <= 9)
  require(time == 1 || time == 0.5 || time == 0.25 || time == 0.125 || time == 0.0625)
  require(0 <= volume && volume <= 100)

  def play: String = {
    Context.midiPlayer.play(key = midiNumber, duration = duration, volume)
    toString
  }

  def midiNumber = keynumber + octave * 12 + 12
  require(Context.midi_lowestkey < midiNumber && midiNumber <= Context.midi_highestkey)

  def duration = {
    val beatsPerMinute = Context.bpm
    val millisecondsInMinute = 1000 * 60
    val measureDuration = (millisecondsInMinute / beatsPerMinute) * 4
    (time * measureDuration).toInt
  }

  def sharp = Key(keynumber + 1)
  def flat = Key(keynumber - 1)

  def speed(t: Double) = { copy(time = t) }

  def + = copy(octave = octave + 1)
  def ++ = copy(octave = octave + 2)
  def - = copy(octave = octave - 1)
  def -- = copy(octave = octave - 2)

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
  def minorTerz = copy(keynumber = this.keynumber + 3)
  def majorTerz = copy(keynumber = this.keynumber + 4)
  def minorQuint = copy(keynumber = this.keynumber + 6)
  def majorQuint = copy(keynumber = this.keynumber + 7)
  def augmentedQuint = copy(keynumber = this.keynumber + 8)
  def minorSetp = copy(keynumber = this.keynumber + 10)
  def majorSetp = copy(keynumber = this.keynumber + 11)
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
    0.5 -> "\u00BD",
    0.25 -> "",
    0.125 -> "1/8",
    0.0625 -> "1/16")

  override def toString = keynumberToString(keynumber) + octaveToString(octave) + timeToString(time)
  def asLy = toString
  def asDSL = toString
}