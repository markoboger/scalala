package de.htwg.scalala.music

case class TimeSignature(num: Int = 4, denom: Int = 4) extends Music {
  override def toString: String = s"TimeSig[$num,$denom]"

  //TODO: Implement!
  def asLy: String = s"""\\time $num/$denom"""
  def asDSL: String = s"[$num,$denom]"
}

object TimeSignature {
  private val r = """\[(\d),(\d)\]""".r

  def apply(str: String): TimeSignature = str match {
    case r(n,d) => new TimeSignature(n.toInt,d.toInt)
  }
}
