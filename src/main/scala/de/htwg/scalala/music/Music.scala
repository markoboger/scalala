package de.htwg.scalala.music

trait Music extends Traversable[Music] {
  def foreach[U](f: Music => U) = f(this)
}
