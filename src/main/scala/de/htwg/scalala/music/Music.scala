package de.htwg.scalala.music

import de.htwg.scalala.midi.MidiPlayer

trait Music {
  def play(instrument: Instrument, volume: Int = Context.volume)
  def *(repetitions: Int): Music
  def *(pattern: Pattern): Music
  def toTickList:List[Option[Music]]
}
