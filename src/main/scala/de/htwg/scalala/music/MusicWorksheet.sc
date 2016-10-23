package de.htwg.scalala.music

import player._
import notes._
import chords._
import javax.sound.midi.{ MidiSystem, Receiver }
import de.htwg.scalala.midi.events.{ NoteOn, NoteOff , ProgramChange}

import scala.language.postfixOps
import de.htwg.scalala.midi.events.ProgramChange

object MusicWorksheet {
 
play(c.mol)                                       //> res0: <error> = ()

Context.player.changeToInstrument(14)

play(f.dur)                                       //> res1: <error> = ()
     

     

 
}