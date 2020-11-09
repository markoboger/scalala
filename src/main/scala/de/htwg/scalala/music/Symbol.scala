package de.htwg.scalala.music

trait Symbol extends MusicElem {
  val ticks = 0
  override def play(instrument: Instrument = Piano, volume: Int) = {} // play nothing for Sympols
  def *(repetitions: Int) = this
  def *(pattern: Pattern) = this
 
}

case class TimeSignature(nominator: Int = 4, denominator: Int = 4) extends Symbol {
  override def toString: String = s"TimeSignature[$nominator / $denominator]"
   def toTickList = List(None)
}

case class Pause(override val ticks: Int = 4) extends Symbol {
  override def play(instrument: Instrument = Piano, volume: Int = 0) = instrument.midiPlayer.play(key = 1, duration = duration, volume = 0)
  override def toString = "-"
   def toTickList = Some(this)::((1 until ticks).toList.map(x=>None))
}

case object Bar extends Symbol  {
  override def play(instrument: Instrument = Piano, volume: Int = 0) = instrument.midiPlayer.play(key = 1, duration = duration, volume = 0)
  override def toString = "|"
   def toTickList = List(None)
}