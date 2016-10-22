import java.net.URL
import de.htwg.scalala.midi.{ Player, Midi, Notes }
import javax.sound.midi.{ MidiSystem, Receiver }
import javax.sound.sampled.{ AudioInputStream, LineEvent, LineListener, AudioSystem }
import java.io.File
import de.htwg.scalala.midi.events.{ NoteOn, NoteOff }

import de.htwg.scalala.midi._

object MidiWorksheet {

  val player = Player(MidiSystem.getReceiver())   //> player  : de.htwg.scalala.midi.Player = Player(com.sun.media.sound.SoftRecei
                                                  //| ver@1eb44e46)
  val url = new URL("http://www.mediacollege.com/audio/tone/files/1kHz_44100Hz_16bit_05sec.wav")
                                                  //> url  : java.net.URL = http://www.mediacollege.com/audio/tone/files/1kHz_4410
                                                  //| 0Hz_16bit_05sec.wav
  //player.play(url)

  val file = new File("Movie_Themes_-_1492_Conquest_of_Paradise.mid")
                                                  //> file  : java.io.File = Movie_Themes_-_1492_Conquest_of_Paradise.mid
  //play(file)

 val receiver: Receiver = MidiSystem.getReceiver()//> receiver  : javax.sound.midi.Receiver = com.sun.media.sound.SoftReceiver@3d8
                                                  //| c7aca/
    receiver.send(NoteOn(0, 64, 90), 0)
    Thread.sleep(1000)
    receiver.send(NoteOff(0, 64, 90), 0)
    
    player.play
    player.play(key=68)
    player.play(key=70, duration=187)
    player.play(key=50, duration=400)
    player.play(key=55, duration=400)
    player.play(key=48, duration=1200)
    
 

 

}