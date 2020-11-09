package de.htwg.scalala.music

import de.htwg.scalala.midi.MidiPlayer

case class Instrument(name: String, instrumentID: Int, channelID: Int = 0) {
  val midiPlayer = MidiPlayer(instrumentID, channelID)

  def play(music: Music, volume:Int=Context.volume) = {
    music.play(this, volume)
  }
  
  override def toString = name

}