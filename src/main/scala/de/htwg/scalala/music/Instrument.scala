package de.htwg.scalala.music

import akka.actor._
import de.htwg.scalala.actors._
import de.htwg.scalala.midi.MidiPlayer

case class Instrument(name: String, instrumentID: Int, channelID: Int = 0) {
  val midiPlayer = MidiPlayer(instrumentID, channelID)

  def play(music: Music) = {
    music.play(this)
  }

}