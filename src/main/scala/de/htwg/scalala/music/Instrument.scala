package de.htwg.scalala.music

case class Instrument(name: String,  program: Int) {

  def play(key: Key) = {
    Context.midiPlayer.changeToInstrument(program)
    key.play
  }

  def play(chord: Chord) = {
    Context.midiPlayer.changeToInstrument(program)
    chord.play
  }
  def play(keys: Key*): Seq[String] = keys.map(key => play(key))
  def play(keys: List[Key]): List[String] = keys.map(key => play(key))
  def play(tuple: Product): Unit = Chord(tuple.productIterator.toSet.map { key: Any => key.asInstanceOf[Key] }).play
  def play(chords: List[Chord]): Unit = chords.map(chord => chord.play)

}