package de.htwg.scalala.music

package object player {

  def play(key: Key): String = key.play 
  def play(keys: List[Key]): List[String] = keys.map(key => play(key))
  def play(tuple: Product): Unit = Chord(tuple.productIterator.toSet.map { key: Any => key.asInstanceOf[Key] }).play
  def play(chord: Chord): Unit = chord.play
  def play(chords: List[Chord]): Unit = chords.map(chord => chord.play)

}