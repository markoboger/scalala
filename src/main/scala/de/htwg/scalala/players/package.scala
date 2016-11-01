package de.htwg.scalala

import de.htwg.scalala.music._
import akka.actor._

package object players {
  val system = ActorSystem("Orchestra")

  def player(instrument: Instrument, name: String = ""): MusicPlayer = {
    val actor = system.actorOf(Props(MusicActor(instrument)), name = if (name == "") instrument.toString + "Actor" else name + "Actor")
    TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(actor)), name = if (name == "") instrument.toString + "Player" else name + "Player")
  }

  val PianoPlayer: MusicPlayer = player(Piano)
  val MarimbaPlayer = player(Marimba)
  val XylophonePlayer = player(Xylophone)
  val OrganPlayer = player(Organ)
  val GuitarPlayer = player(Guitar)
  val BassPlayer = player(Bass)
  val ViolinPlayer = player(Violin)
  val CelloPlayer = player(Cello)
  val TrumpetPlayer = player(Trumpet)
  val TubaPlayer = player(Tuba)
  val HornPlayer = player(Horn)
  val SaxPlayer = player(Sax)
  val OboePlayer = player(Oboe)
  val ClarinetPlayer = player(Clarinet)
  val FlutePlayer = player(Flute)

  val DrumPlayer = player(Drum)

  val Conductor = system.actorOf(Props(classOf[Conductor]), "Conductor")

}
