package de.htwg.scalala.music

trait Music {
  def play(instrument: Instrument, volume: Int = Context.volume)
  def *(repetitions: Int): Music
  def *(pattern: Pattern): Music
  def toTickList:List[Option[Music]]
}
