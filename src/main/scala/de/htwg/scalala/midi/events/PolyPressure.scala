
package de.htwg.scalala.midi.events

/**
 * Factory object for PolyPressure messages
 */
object PolyPressure {
   def apply(channel: Int, key: Int, pressure: Int) = {
     ShortMessage(javax.sound.midi.ShortMessage.POLY_PRESSURE, channel, key, pressure)
   }
}