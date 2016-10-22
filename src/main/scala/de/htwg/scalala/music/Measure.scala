package de.htwg.scalala.music

case class Measure(timeSignature: TimeSignature=Context.timeSignature, music: Music*) extends Music {
  override def foreach[U](f: Music => U) = music foreach f
  override def toString: String = s"Measure($timeSignature, $music)"

  def asLy: String = s"""${timeSignature.asLy} ${music.foldLeft("")((s, m) => s+m.asLy+" ")}|"""
  def asDSL: String = s"""${timeSignature.asDSL} ${music.foldLeft("")((s, m) => s+m.asDSL+" ")}|"""
}
