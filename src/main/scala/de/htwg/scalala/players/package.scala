package de.htwg.scalala

import de.htwg.scalala.music._
import akka.actor._

package object players {
  val system = ActorSystem("Orchestra")
  
    def player(instrument:Instrument, name:String="") :MusicPlayer= {
      
      val actor = system.actorOf(Props(MusicActor(instrument)), name = if (name=="") instrument.toString+"Actor" else name)
      TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(actor)), name = if (name=="") instrument.toString+"Player" else name)
    }

  val PianoPlayer: MusicPlayer = player(Piano)
  val MarimbaPlayer = player(Marimba)
  val XylophonePlayer = player(Xylophone)
  val OrganPlayer = player(Organ)
  val GuitarPlayer = player(Guitar)
  val BassPlayer= player(Bass)
  val ViolinPlayer = player(Violin)
  val CelloPlayer = player(Cello)
  val TrumpetPlayer = player(Trumpet)
  val TubaPlayer = player(Tuba)
  val HornPlayer = player(Horn)
  val DrumPlayer = player(Drum)
  val SaxPlayer = player(Sax)
  val OboePlayer = player(Oboe)
  val ClarinetPlayer= player(Clarinet)
  val FlutePlayer = player(Flute)

}
