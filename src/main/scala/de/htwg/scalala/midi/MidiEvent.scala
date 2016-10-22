
package de.htwg.salala.midi

import javax.sound.midi.MidiMessage

/**
 * Factory object for javax.sound.midi.MidiEvent
 */
object MidiEvent {

  /**
   *
   * @param msg
   * @param tick
   * @return javax.sound.midi.MidiEvent instance
   */
  def apply(msg: MidiMessage, tick: Long) = {
    new javax.sound.midi.MidiEvent(msg, tick)
  }

  def unapply(event: javax.sound.midi.MidiEvent) = {
    Some(event.getMessage, event.getTick)
  }
}
