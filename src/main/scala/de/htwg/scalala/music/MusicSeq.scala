package de.htwg.scalala.music

import de.htwg.scalala.midi.MidiPlayer

trait MusicSeq extends Music with Traversable[Music] {
  private val generator = scala.util.Random
  var repeat = 1
  var pattern = Pattern(1)
  def foreach[U](f: Music => U) = f(this)
  def play(instrument: Instrument = Piano, volume: Int) = for (i <- 1 to repeat; part <- pattern) {
    seq.foreach(_.play(instrument, volume = volume * part))
  }
  def *(_pattern: Pattern): MusicSeq = { pattern = _pattern; this }
  def *(rep: Int): MusicSeq = { repeat = repeat * rep; this }
  override def size = this.seq.size
  def choose = seq.toIndexedSeq(generator.nextInt(size))
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

