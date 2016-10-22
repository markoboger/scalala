
package de.htwg.scalala.midi.events

object ChannelPressure {
  /**
   *
   * @param channel MIDI channel for this message
   * @param pressure Pressure value
   * @return
   */
  def apply(channel: Int, pressure: Int) = {
    ShortMessage(javax.sound.midi.ShortMessage.CHANNEL_PRESSURE, channel, pressure)
  }
}