import de.htwg.scalala.music._
import de.htwg.scalala.players._
import scala.language.postfixOps

val LeftPiano = player(Piano, "LeftPiano")
val RightPiano  = player(Piano, "RightPiano")
Conductor!Add(LeftPiano)
Conductor!Add(RightPiano)
Conductor!Add (DrumPlayer)
Conductor!Start

val right = Line(d16, e16, fis, a, fis, e8, d2.dot, fis8, a8, Chord(d1, g1, b1), d8, c, a, Chord(a1-, d2, fis2))
val left = Line(d-, a, d, a, d-, a, d, a, g, d, g, d, a)

RightPiano.play(right)
LeftPiano.play(left)
DrumPlayer.play(c*Pattern(1,0,0,0)*4)
