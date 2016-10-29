package de.htwg.scalala.music

case class Pattern(pattern:Int*) extends Traversable[Int]{
  def foreach[U](f: Int => U) = pattern.foreach{ f}  
}