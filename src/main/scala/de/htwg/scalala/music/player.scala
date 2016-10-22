package de.htwg.scalala.music

package object player {

  def play(key: Key): String = {
    Context.player.play(key = key.midiNumber, duration = key.duration, key.volume)
    key.toString
  }
  def play(keys: List[Key]): List[String] = keys.map(key => play(key))
  def play(tuple: Product): Set[Key] = {
    val set=tuple.productIterator.toSet.map { key: Any => key.asInstanceOf[Key] }
    play(set)
    set
  }
  def play(set: Set[Key]): Set[String] = {
    val duration = set.toVector(0).duration
    val volume = set.toVector(0).volume
    set.foreach { key => Context.player.start(key = key.midiNumber, volume) }
    Thread.sleep(duration)
    set.foreach { key => Context.player.stop(key.midiNumber, volume) }
    set.map(_.toString)
  }

}