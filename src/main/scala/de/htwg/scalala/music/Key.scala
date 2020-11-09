package de.htwg.scalala.music

import scala.language.postfixOps

case class Key(
    val midiNumber: Int,
    repeat: Int = 1,
    pattern: Pattern = Pattern(1),
    ticks:Int = 4,
    volume: Int = Context.volume) extends MusicElem {
  require(0 <= midiNumber && midiNumber <= 128)
  require(0 <= volume && volume <= 100)

  def play(instrument: Instrument = Piano, volume:Int=volume): Unit = for (i <- 1 to repeat; part <- pattern) {
    instrument.midiPlayer.play(key = midiNumber, duration = duration, volume=volume*part)
  }
  def toTickList:List[Option[Music]] = {
      (1 to repeat).toList.flatMap(x=> pattern.flatMap(part=>Some(this.copy(volume=volume*part))::((1 until ticks).toList.map(x=>None))))
  }

  def *(pattern: Pattern): Key = copy(pattern = pattern)
  def *(repetitions: Int): Key = copy(repeat = repetitions)

  val keynumber = midiNumber % 12
  val octave = midiNumber / 12 - 1

  def sharp = Key(midiNumber + 1)
  def flat = Key(midiNumber - 1)
  def dot = copy(ticks = (ticks * 1.5).toInt)

  def ticks(ticks: Int) = { copy(ticks = ticks) }

  def + = copy(midiNumber = midiNumber + 12)
  def ++ = copy(midiNumber = midiNumber + 24)
  def - = copy(midiNumber = midiNumber - 12)
  def -- = copy(midiNumber = midiNumber - 24)

  def soft = copy(volume = volume - Context.softDecrease)
  def ? = soft
  def hard = copy(volume = volume + Context.hardIncrease)
  def ! = hard

  def chord(chordQuality: ChordQuality.Value): Chord = {
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
  def maj: Chord = chord(ChordQuality.Major)
  def dur: Chord = maj
  def min: Chord = chord(ChordQuality.Minor)
  def mol: Chord = min
  def dim: Chord = chord(ChordQuality.Diminshed)
  def aug: Chord = chord(ChordQuality.Augmented)
  def maj7 = chord(ChordQuality.MajorSeventh)
  def min7 = chord(ChordQuality.MinorSeventh)
  
  def scale(scaleType: ScaleType.Value = ScaleType.Major) = Scale(this,scaleType)
    
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
  val ticksToString = Map(
    16 -> "\u1D15D",
    12 -> "\u00BD\u00B7",
    8 -> "\u00BD",
    6 -> "\u00B7",
    4 -> "",
    3 -> "1/8\u00B7",
    2 -> "1/8",
    1 -> "1/16",
    0 -> "|")

  override def toString = if (midiNumber == 128) "|" else if (volume == 0) "-" else keynumberToString(keynumber) + octaveToString(octave) + ticksToString(ticks)
  override def equals(that: Any): Boolean =
    that match {
      case that: Key => (this.midiNumber == that.midiNumber) && (this.ticks == that.ticks)
      case _         => false
    }
}

object Key {

}