package de.htwg.scalala.music

import notes._
import player._

case class Chord(set: Set[Key], name:String ="") extends Music {
  def play: Unit = Context.midiPlayer.play(set)
  override def toString = if (name =="" ) "[" + set.foreach(_.toString) + "]" else name
  def asLy = toString
  def asDSL = toString
}

object Chord {

  def apply(keys: Key*): Chord = {
    Chord(keys.toSet)
  }

  def apply(rootkey: Key, chordQuality: ChordQuality.Value): Chord = {
    rootkey.findChord(chordQuality)
  }
  private val root = """([a-g,A-G])([n|#|x|X|\-|_]?)([,|']*)"""
  private val qual = """(M|m|maj|min|mol|dur)"""
  private val r = s"""$root:$qual""".r

}

object ChordQuality extends Enumeration {
  type ChordQuality = Value
  val Major, Minor, Diminshed, Augmented, Seventh, MajorSeventh, MinorSeventh = Value
}
