
package de.htwg.scalala.midi.events

/**
 * Factory object for NoteOff messages
 */
object NoteOff {
  def apply(channel: Int, key: Int, velocity: Int) = {
    ShortMessage(javax.sound.midi.ShortMessage.NOTE_OFF, channel, key, velocity)
  }
}