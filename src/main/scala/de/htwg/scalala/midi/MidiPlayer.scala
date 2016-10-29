
package de.htwg.scalala.midi

import de.htwg.scalala.music.{Key, Context}

import javax.sound.midi.{ MidiSystem, Synthesizer }

case class MidiPlayer(instrumentID:Int=0, channelID:Int=0) {

  val synthesizer = MidiSystem.getSynthesizer
  synthesizer.open
  val channels = synthesizer.getChannels
  val channel = channels.apply(channelID)
  changeToInstrument(instrumentID)

  def play(key: Int = 60, duration: Int = 800, volume: Int = Context.volume): Unit = {
    
    channel.noteOn(key, volume)
    Thread.sleep(duration)
    channel.noteOff(key, volume)
  }
  def play(set: Set[Key], volume:Int): Unit = {
    val duration = set.head.duration
    set.foreach { key => start(key = key.midiNumber, volume=volume) }
    Thread.sleep(duration)
    set.foreach { key => stop(key.midiNumber, volume=volume) }
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