import de.htwg.scalala.music._
import de.htwg.scalala.players._

Conductor!Add(PianoPlayer)
Conductor!Add(CelloPlayer)
Conductor!Start

val voice1 = Tune(e2, e2, |, f2, e2, |, g, g, f, e, |, f2, e2)
val voice2 = Tune(c, g, c, g, |, a, f, c, g, |, e, e, d, c, |, d, b, c2)

PianoPlayer.play(voice1)
CelloPlayer.play(voice2)
