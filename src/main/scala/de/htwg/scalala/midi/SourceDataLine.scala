
package de.htwg.scalala.midi

import java.net.URL
import java.io.File
import javax.sound.sampled.{AudioSystem, AudioFormat}
import de.htwg.scalala.midi._
/**
 * Factory object for SourceDataLine
 */
object SourceDataLine {

  def apply(format: AudioFormat): javax.sound.sampled.SourceDataLine = {
    AudioSystem.getSourceDataLine(format)
  }

  /**
   * Creates a SourceDataLine for the specified file
   * @param file
   * @return
   */
  def apply(file: File): javax.sound.sampled.SourceDataLine = {
    apply(AudioSystem.getAudioInputStream(file))
  }

  /**
   * Creates a SourceDataLine for the specified URL
   * @param url
   * @return
   */
  def apply(url: URL): javax.sound.sampled.SourceDataLine = {
    apply(AudioSystem.getAudioInputStream(url))
  }
}