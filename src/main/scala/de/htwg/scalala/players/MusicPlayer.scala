package de.htwg.scalala.players

import akka.actor._
import de.htwg.scalala.music._
import scala.concurrent.duration._
import scala.language.postfixOps
import scala.concurrent.ExecutionContext.Implicits.global
import de.htwg.scalala.midi._

case class MusicActor(instrument: Instrument) extends Actor {
  var tickList: List[Option[Music]] = List()

  def receive = {
    case Tick(tickNum)               => playNextKey
    case PlayNow(_tickList) => tickList = _tickList
    case PlayAt(tick, _tickList) => tickList = (1 until tick).toList.map(x=>None):::_tickList
  }

  def playNextKey = {
    if (tickList != Nil) {
      tickList.head match {
        case None               =>
        case Some(key: Key)     => playKey(key)
        case Some(chord: Chord) => chord.set.foreach(key => playKey(key.copy(ticks = chord.ticks, volume = chord.volume)))
        case _                  =>
      }
      tickList = tickList.tail
    }

  }
  def playKey(key: Key) = {
    instrument.midiPlayer.start(key.midiNumber, key.volume)
    system.scheduler.scheduleOnce(Context.tickduration * key.ticks) { instrument.midiPlayer.stop(key.midiNumber, key.volume) }
  }
}

trait MusicPlayer {
  val actor: ActorRef
  def play(music: Music)
  def playAt(tick:Int, music:Music)
}

case class MusicPlayerImpl(musicActor: ActorRef) extends MusicPlayer {
  val actor = musicActor
  def play(music: Music): Unit = musicActor ! PlayNow(music.toTickList)
  def playAt(tick:Int, music:Music):Unit = musicActor ! PlayAt(tick, music.toTickList) 
}


