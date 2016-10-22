package de.htwg.scalala.music

import de.htwg.util.rational._
import scala.language.postfixOps

case class Note(pitch: Pitch, val fraction: Double = 1 / 4) extends Music {

  def duration = {
    val beatsPerMinute = Context.bpm
    val millisecondsInMinute = 1000 * 60
    val measureDuration = (millisecondsInMinute / beatsPerMinute) * 4
    (fraction * measureDuration).toInt
  }
  def + = Note(Pitch(pitch.pitchClass, pitch.decorator, pitch.octave + 1), fraction)
  def ++ = Note(Pitch(pitch.pitchClass, pitch.decorator, pitch.octave + 2), fraction)
  def - = Note(Pitch(pitch.pitchClass, pitch.decorator, pitch.octave - 1), fraction)
  def -- = Note(Pitch(pitch.pitchClass, pitch.decorator, pitch.octave - 2), fraction)

  override def toString: String = s"<${pitch.toString} $fraction>"
  def asLy: String = s"${pitch.asLy}" //{$fraction.asLy}"
  def asDSL: String = s"${pitch.asDSL}" //${fraction.asDSL}"
}
