package de.htwg.scalala.music

import de.htwg.scalala.midi.MidiPlayer

object Context {

  val instrument = Piano
  var timeSignature = TimeSignature(4, 4)
  var octave = 4
  var bpm = 80
  var fraction: Double = 0.25
  var volume = 75
  var hardIncrease = 25
  var softDecrease = 25
  require(volume + hardIncrease <= 100)
  require(0 < volume - softDecrease)
  val midi_lowestkey = 0
  val midi_highestkey = 127

}