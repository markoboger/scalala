package de.htwg.scalala.music

import de.htwg.scalala.midi.MidiPlayer

trait Music { 
  def play (instrument:Instrument)
}
