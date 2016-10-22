
package de.htwg.scalala.midi

import de.htwg.scalala.midi._
import Notes._
import events.{ NoteOn, NoteOff }

import javax.sound.midi.{ MidiSystem, Receiver }
import javax.sound.sampled.{ AudioInputStream, LineEvent, LineListener, AudioSystem }
import java.io.File
import java.net.URL

case class Player(receiver: Receiver = MidiSystem.getReceiver()) {

  def play: Unit = play(key = 60, duration = 800, volume = 93)
  def play(key: Int = 60, duration: Int = 800, volume: Int = 93): Unit = {
    receiver.send(NoteOn(0, key, volume), -1)
    Thread.sleep(duration)
    receiver.send(NoteOff(0, key, volume), -1)
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

}