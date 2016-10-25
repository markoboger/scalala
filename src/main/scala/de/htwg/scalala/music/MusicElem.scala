package de.htwg.scalala.music

trait MusicElem extends Music {
  val time:Double
  def duration = {
    val beatsPerMinute = Context.bpm
    val millisecondsInMinute = 1000 * 60
    val measureDuration = (millisecondsInMinute / beatsPerMinute) * 4
    (time * measureDuration).toInt
  }
}