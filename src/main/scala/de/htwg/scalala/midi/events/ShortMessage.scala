
package de.htwg.scalala.midi.events

/**
 * Factory object for javax.sound.midi.ShortMessage
 */
object ShortMessage {

  /**
   *
   * @param command MIDI command
   * @param channel MIDI channel
   * @param data1 first data byte
   * @return javax.sound.midi.ShortMessage instance
   */
  def apply(command: Int, channel: Int, data1: Int) = {
    val msg = new javax.sound.midi.ShortMessage
    msg.setMessage(command, channel, data1)
    msg
  }

  /**
   *
   * @param command MIDI command
   * @param channel MIDI channel
   * @param data1
   * @param data2
   * @return javax.sound.midi.ShortMessage instance
   */
  def apply(command: Int, channel: Int, data1: Int, data2: Int) = {
    val msg = new javax.sound.midi.ShortMessage
    msg.setMessage(command, channel, data1, data2)
    msg
  }
}