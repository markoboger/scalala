package de.htwg.scalala.music

import de.htwg.scalala.midi.MidiPlayer

trait Symbol extends MusicElem {
  val time = 0.0
  override def play(instrument: Instrument = Piano, volume: Int) = {} // play nothing for Sympols
  def *(repetitions: Int) = this
  def *(pattern: Pattern) = this
}

case class TimeSignature(nominator: Int = 4, denominator: Int = 4) extends Symbol {
  override def toString: String = s"TimeSignature[$nominator / $denominator]"
}

case class Pause(override val time: Double = 0.25) extends Symbol {
  override def play(instrument: Instrument = Piano, volume: Int = 0) = instrument.midiPlayer.play(key = 1, duration = duration, volume = 0)
  override def toString = "-"
}

case object Bar extends Symbol  {
  override val time: Double = 0.0
  override def play(instrument: Instrument = Piano, volume: Int = 0) = instrument.midiPlayer.play(key = 1, duration = duration, volume = 0)
  override def toString = "|"
}