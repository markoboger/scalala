
package de.htwg.scalala.midi

import de.htwg.scalala.midi._
import events.{ NoteOn, NoteOff, ProgramChange }
import de.htwg.scalala.music.Key

import javax.sound.midi.{ MidiSystem, Receiver , Synthesizer}
import javax.sound.sampled.{ AudioInputStream, LineEvent, LineListener, AudioSystem }
import java.io.File
import java.net.URL

case class Player() {
  
  val synthesizer = MidiSystem.getSynthesizer
  synthesizer.open()
  val receiver = synthesizer.getReceiver

  def play: Unit = play(key = 60, duration = 800, volume = 93)
  def play(key: Int = 60, duration: Int = 800, volume: Int = 93): Unit = {
    receiver.send(NoteOn(0, key, volume), -1)
    Thread.sleep(duration)
    receiver.send(NoteOff(0, key, volume), -1)
  }
  def play(set: Set[Key]): Unit = {
    val duration = set.toVector(0).duration
    val volume = set.toVector(0).volume
    set.foreach { key => start(key = key.midiNumber, volume) }
    Thread.sleep(duration)
    set.foreach { key => stop(key.midiNumber, volume) }
    //set.map(_.toString)
  }
  
  def play(notes: List[Int]): Unit = {
    notes.foreach { note: Int => play(note) }
  }

  def play(file: File): Unit = play(AudioSystem.getAudioInputStream(file))
  def play(url: URL): Unit = play(AudioSystem.getAudioInputStream(url))

  def play(stream: AudioInputStream) {
    using(SourceDataLine(stream)) {
      line =>
        {
          line.addLineListener((e: LineEvent) => { println(e) })
          stream >> line
        }
    }
  }

  def start(key: Int, volume: Int): Unit = {
    receiver.send(NoteOn(0, key, volume), 0)
  }

  def stop(key: Int, volume: Int): Unit = {
    receiver.send(NoteOff(0, key, volume), 4000)
  }
  
  def changeToInstrument(instrumentID:Int = 0) = {
    synthesizer.open
    val soundBank = synthesizer.getDefaultSoundbank
    val instruments = soundBank.getInstruments
    val instrument=instruments(instrumentID)
    val channels = synthesizer.getChannels
    val channel = channels(4) 
    receiver.send(NoteOn(0, 60, 100), -1)
    synthesizer.loadInstrument(instrument) 
    receiver.send(ProgramChange(4,4), -1)
    receiver.send(NoteOn(0,70,100), -1)
     Thread.sleep(800)
  }

}