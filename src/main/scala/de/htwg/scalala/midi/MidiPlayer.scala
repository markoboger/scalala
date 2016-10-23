
package de.htwg.scalala.midi

import de.htwg.scalala.music.Key

import javax.sound.midi.{ MidiSystem, Synthesizer }
import javax.sound.sampled.{ AudioInputStream, LineEvent, LineListener, AudioSystem }
import java.io.File
import java.net.URL

case class MidiPlayer() {

  val synthesizer = MidiSystem.getSynthesizer
  synthesizer.open()
  val channels = synthesizer.getChannels
  val soundBank = synthesizer.getDefaultSoundbank
  val instruments = soundBank.getInstruments
  synthesizer.open

  def play: Unit = play(key = 60, duration = 800, volume = 93)
  def play(key: Int = 60, duration: Int = 800, volume: Int = 93, channelID: Int = 0): Unit = {
    val channel = channels.apply(channelID)
    channel.noteOn(key, volume)
    Thread.sleep(duration)
    channel.noteOff(key, volume)
  }
  def play(set: Set[Key]): Unit = {
    val duration = set.toVector(0).duration
    val volume = set.toVector(0).volume
    set.foreach { key => start(key = key.midiNumber, volume) }
    Thread.sleep(duration)
    set.foreach { key => stop(key.midiNumber, volume) }
  }

  def start(key: Int, volume: Int, channelID: Int = 0): Unit = {
    val channel = channels.apply(channelID)
    channel.noteOn(key, volume)
  }

  def stop(key: Int, volume: Int, channelID: Int = 0): Unit = {
    val channel = channels.apply(channelID)
    channel.noteOff(key, volume)
  }

  def changeToInstrument(instrumentID: Int = 0, channelID: Int = 0) = {
    val channel = channels(channelID)
    channel.programChange(instrumentID)
    
  }

}