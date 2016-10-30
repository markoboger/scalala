package de.htwg.scalala.music

import scala.language.postfixOps
import de.htwg.scalala.players._

object MusicWorksheet {

val tune1= Tune (c, d, e, f, g, a, b)             //> tune1  : de.htwg.scalala.music.Tune = (c, d, e, f, g, a, b)
val pat= Pattern (1,1,1,1)                        //> pat  : de.htwg.scalala.music.Pattern = Pattern(1, 1, 1, 1)

  val percs = Tune(DrumBass, HiHatPedal, HiHatClosed, CowBell)*4
                                                  //> percs  : de.htwg.scalala.music.MusicSeq = (c,,, g♯,,, f♯,,, g♯,)
 
 val DrumPlayer2=player(Drum, "Drum2")            //> DrumPlayer2  : de.htwg.scalala.players.MusicPlayer = Actor[akka://Orchestra/
                                                  //| user/Drum2Player#420204324]|
 
 play(Tune(c.dur, e.dur, g.dur).choose)
    
        
  //DrumPlayer.play(percs)
 //DrumPlayer2.play(TomHigh*Pattern(0,1,0,1)*4)
}