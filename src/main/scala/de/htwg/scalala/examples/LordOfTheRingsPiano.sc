import de.htwg.scalala.music._
import de.htwg.scalala.players._
import scala.language.postfixOps
 


  val LeftPiano = player(Piano, "LeftPiano")      //> LeftPiano  : de#29.htwg#17819.scalala#17821.players#17829.MusicPlayer#166398
                                                  //| 84 = Actor[akka://Orchestra/user/LeftPianoPlayer#-1587307681]
  val RightPiano  = player(Piano, "RightPiano")   //> RightPiano  : de#29.htwg#17819.scalala#17821.players#17829.MusicPlayer#16639
                                                  //| 884 = Actor[akka://Orchestra/user/RightPianoPlayer#1250671573]
  Conductor!Add(LeftPiano)
  Conductor!Add(RightPiano)
  Conductor!Add (DrumPlayer)
  Conductor!Start
  var right = Line(d16, e16, fis, a, fis, e8, d2.dot, fis8, a8, Chord(d1, g1, b1), d8, c, a, Chord(a1-, d2, fis2))
                                                  //> Conductor Started
                                                  //| right  : de#29.htwg#17819.scalala#17821.music#17827.Line#26805077 = [d1/16, 
                                                  //| e1/16, f♯, a, f♯, e1/8, d½·, f♯1/8, a1/8, [(]], d1/8, c, a, [(]]]

  var left = Line(d-, a, d, a, d-, a, d, a, g, d, g, d, a)
                                                  //> left  : de#29.htwg#17819.scalala#17821.music#17827.Line#26805077 = [d,, a, d
                                                  //| , a, d,, a, d, a, g, d, g, d, a]|
  
  RightPiano.play(right)
  LeftPiano.play(left)
  DrumPlayer.play(c*Pattern(1,0,0,0)*4)
