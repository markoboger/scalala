Scalala - A DSL to create and play music from within Scala code
=========================

This project allows to write music within a Scala program and to play it via a MIDI player.
Here is a simple example of a piece of music in Scalala notation:

val start = Line(c8, f.dot, a8, c.dot+, b8, a, g, f.dot)
val middle = Line(p8, g8, g8, g8, b8, a, f8)
val end = Line(p8, c+, d+, c8+, b8, a8, f8, a, g, f.dot)

play(Track(start, middle , middle , end))


Scalala also allows to play several instruments in parallel. For this Scalala uses Actors. 
Here is an example of that: 

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
