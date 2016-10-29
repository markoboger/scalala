package de.htwg.scalala.music

import scala.language.postfixOps
import de.htwg.scalala.players._

object MusicWorksheet {

val p = Pattern(1,1,0,1)
val t1 = Tune (c8.dur, c16.dur,c16.dur )*p
val t2 = Tune (d.mol)*p
val t3 = Tune(t1, t2)*8
//PianoPlayer.play(t3)

val p2 = Pattern(1,0,1,0)
val t4 = Tune( c8-, d8-, d8-, c8-)*p2

CelloPlayer.play(t4 *8)
 
val dr = Tune (c,d) *Pattern(1,0,0 ,0)*8
DrumPlayer.play(dr)
 
}