package de.htwg.scalala

import de.htwg.scalala.actors._
import de.htwg.scalala.music._
import akka.actor._

package object players {
  val system = ActorSystem("Orchestra")

  val PianoActor = system.actorOf(Props(MusicActor(Piano)), name = "pianoActor")
  val MarimbaActor = system.actorOf(Props(MusicActor(Marimba)), name = "marimbaActor")
  val XylophoneActor = system.actorOf(Props(MusicActor(Xylophone)), name = "XylophoneActor")
  val OrganActor = system.actorOf(Props(MusicActor(Organ)), name = "organActor")
  val GuitarActor = system.actorOf(Props(MusicActor(Guitar)), name = "guitarActor")
  val BassActor = system.actorOf(Props(MusicActor(Bass)), name = "bassActor")
  val ViolinActor = system.actorOf(Props(MusicActor(Violin)), name = "violinActor")
  val CelloActor = system.actorOf(Props(MusicActor(Cello)), name = "celloActor")
  val TrumpetActor = system.actorOf(Props(MusicActor(Trumpet)), name = "trumpetActor")
  val TubaActor = system.actorOf(Props(MusicActor(Tuba)), name = "tubaActor")
  val HornActor = system.actorOf(Props(MusicActor(Horn)), name = "hornActor")
  val SaxActor = system.actorOf(Props(MusicActor(Sax)), name = "saxActor")
  val OboeActor = system.actorOf(Props(MusicActor(Oboe)), name = "oboeActor")
  val ClarinetActor = system.actorOf(Props(MusicActor(Clarinet)), name = "clarinetActor")
  val FluteActor = system.actorOf(Props(MusicActor(Flute)), name = "fluteActor")

  val PianoPlayer: MusicPlayer = TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(PianoActor)), "pianoPlayer")
  val MarimbaPlayer: MusicPlayer = TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(MarimbaActor)), "marimbaPlayer")
  val XylophonePlayer: MusicPlayer = TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(XylophoneActor)), "xylophonePlayer")
  val OrganPlayer: MusicPlayer = TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(OrganActor)), "organPlayer")
  val GuitarPlayer: MusicPlayer = TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(GuitarActor)), "guitarPlayer")
  val BassPlayer: MusicPlayer = TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(BassActor)), "bassPlayer")
  val ViolinPlayer: MusicPlayer = TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(ViolinActor)), "violinPlayer")
  val CelloPlayer: MusicPlayer = TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(CelloActor)), "celloPlayer")
  val TrumpetPlayer: MusicPlayer = TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(TrumpetActor)), "trumpetPlayer")
  val TubaPlayer: MusicPlayer = TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(TubaActor)), "tubaPlayer")
  val HornPlayer: MusicPlayer = TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(HornActor)), "hornPlayer")
  val SaxPlayer: MusicPlayer = TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(SaxActor)), "saxPlayer")
  val OboePlayer: MusicPlayer = TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(OboeActor)), "oboePlayer")
  val ClarinetPlayer: MusicPlayer = TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(ClarinetActor)), "clarinetPlayer")
  val FlutePlayer: MusicPlayer = TypedActor(system).typedActorOf(TypedProps(classOf[MusicPlayerImpl], new MusicPlayerImpl(FluteActor)), "flutePlayer")

  def stop = {
    TypedActor(system).stop(PianoPlayer)
    TypedActor(system).stop(CelloPlayer)
  }

}
