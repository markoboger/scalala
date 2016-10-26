
package de.htwg.scalala.midi

import de.htwg.scalala.music.Key

import javax.sound.midi.{ MidiSystem, Synthesizer }

case class MidiPlayer(instrumentID:Int=0, channelID:Int=0) {

  val synthesizer = MidiSystem.getSynthesizer
  synthesizer.open
  val channels = synthesizer.getChannels
  val channel = channels.apply(channelID)
  changeToInstrument(instrumentID)

  def play: Unit = play(key = 60, duration = 800, volume = 75)
  def play(key: Int = 60, duration: Int = 800, volume: Int = 75): Unit = {
    
    channel.noteOn(key, volume)
    Thread.sleep(duration)
    channel.noteOff(key, volume)
  }
  def play(set: Set[Key]): Unit = {
    val duration = set.head.duration
    val volume = set.head.volume
    set.foreach { key => start(key = key.midiNumber, volume) }
    Thread.sleep(duration)
    set.foreach { key => stop(key.midiNumber, volume) }
  }

  def start(key: Int, volume: Int=75): Unit = {
    channel.noteOn(key, volume)
  }

  def stop(key: Int, volume: Int=75): Unit = {
    channel.noteOff(key, volume)
  }

  def changeToInstrument(instrumentID: Int = 0) = {
    channel.programChange(instrumentID)
  }

}