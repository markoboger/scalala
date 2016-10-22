package de.htwg.scalala.music

case class Key(keynumber: Int, octave: Int = Context.octave, time: Double = Context.fraction, volume: Int = Context.volume) {
  require(0 <= keynumber && keynumber < 12)
  require(-1 <= octave && octave <= 9)
  require(time == 1 || time == 0.5 || time == 0.25 || time == 0.125 || time == 0.0625)
  require(0 <= volume && volume <= 100)

  def midiNumber = keynumber + octave * 12 +12
  require(Context.midi_lowestkey < midiNumber && midiNumber <= Context.midi_highestkey)
  
  def duration = {
    val beatsPerMinute = Context.bpm
    val millisecondsInMinute = 1000 * 60
    val measureDuration = (millisecondsInMinute / beatsPerMinute) * 4
    (time * measureDuration).toInt
  }

  def sharp = {
    Key(keynumber + 1)
  }

  def flat = {
    Key(keynumber - 1)
  }

  def speed(t: Double) = { copy(time = t) }

  def + = copy(octave = octave + 1)
  def ++ = copy(octave = octave + 2)
  def - = copy(octave = octave - 1)
  def -- = copy(octave = octave - 2)
  
  def soft = copy(volume = volume - Context.softDecrease)
  def ? = soft
  def hard = copy(volume = volume + Context.hardIncrease)
  def ! = hard
  
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
      1.0 -> "",
      0.5 -> "\u00BD",
      0.25 -> "\u00BC",
      0.125 -> "1/8",
      0.0625 -> "1/16")
     
   override def toString = keynumberToString(keynumber) + octaveToString(octave) + timeToString(time)
}