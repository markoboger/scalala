package de.htwg.scalala.music

trait MusicSeq extends Music with Traversable[Music]  {
  def foreach[U](f: Music => U) = f(this)
  def play = seq.foreach(_.play)
  def play(instrument:Instrument) = seq.foreach(_.play(instrument))
}

case class Tune(override val seq: Music*) extends MusicSeq {
  override def toString: String = "(" + seq.foreach(_.toString) + ")"
}
case class Line(override val seq: Music*) extends MusicSeq {
  override def toString: String = "[" + seq.foreach(_.toString) + "]"
}
case class Track(override val seq: Music*) extends MusicSeq {
  override def toString: String = "{" + seq.foreach(_.toString) + "}"
}

