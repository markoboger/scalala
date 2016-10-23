
package de.htwg.scalala.midi.events

/**
 * Factory object for PitchBend messages
 */
object PitchBend {
  def apply(channel: Int, pressure: Int) = {
    ShortMessage(javax.sound.midi.ShortMessage.PITCH_BEND, channel, pressure)
  }
}