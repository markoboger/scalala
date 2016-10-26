package de.htwg.scalala.music

import de.htwg.scalala.midi.MidiPlayer

trait MusicSeq extends Music with Traversable[Music]  {
  def foreach[U](f: Music => U) = f(this)
  def play(instrument:Instrument=Piano) = seq.foreach(_.play(instrument))
}

case class Tune(override val seq: Music*) extends MusicSeq {
  override def toString: String = seq.toString.replace("WrappedArray(", "(").replace(")", ")")
}
case class Line(override val seq: Music*) extends MusicSeq {
  override def toString: String = seq.toString.replace("WrappedArray(", "[").replace(")", "]")
}
case class Track(override val seq: Music*) extends MusicSeq {
  override def toString: String = seq.toString.replace("WrappedArray(", "{").replace(")", "}")
}

