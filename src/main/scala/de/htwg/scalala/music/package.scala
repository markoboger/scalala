package de.htwg.scalala

package object music {

  def play(musicSeq: Music*): Unit = musicSeq.map(music => music match {
    case elem: MusicElem => Piano.play(elem, volume = Context.volume)
    case seq: MusicSeq   => seq.map(elem => Piano.play(elem, Context.volume))
  })
  def choose(music: MusicSeq): Music = {
    val generator = scala.util.Random
    val index = generator.nextInt(music.size)
    music.seq.toIndexedSeq(index)
  }
  def loop[A](n: Int)(f: => A) { if (n > 0) { f; loop(n - 1)(f) } }

  val Piano = Instrument(name = "Piano", instrumentID = 0, channelID = 0)
  val Marimba = Instrument(name = "Marimba", instrumentID = 13, channelID = 1)
  val Xylophone = Instrument(name = "Xylophone", instrumentID = 14, channelID = 2)
  val Organ = Instrument(name = "Organ", instrumentID = 20, channelID = 3)
  val Guitar = Instrument(name = "Guitar", instrumentID = 25, channelID = 4)
  val Bass = Instrument(name = "Bass", instrumentID = 33, channelID = 5)
  val Violin = Instrument(name = "Violin", instrumentID = 41, channelID = 6)
  val Cello = Instrument(name = "Cello", instrumentID = 43, channelID = 7)
  val Trumpet = Instrument(name = "Trumpet", instrumentID = 57, channelID = 8)
  val Tuba = Instrument(name = "Tuba", instrumentID = 59, channelID = 10)
  val Horn = Instrument(name = "Horn", instrumentID = 61, channelID = 11)
  val Sax = Instrument(name = "Sax", instrumentID = 68, channelID = 12)
  val Oboe = Instrument(name = "Oboe", instrumentID = 69, channelID = 13)
  val Clarinet = Instrument(name = "Clarinet", instrumentID = 72, channelID = 14)
  val Flute = Instrument(name = "Flute", instrumentID = 74, channelID = 15)

  val Drum = Instrument(name = "Drum", instrumentID = 115, channelID = 9)

  val TomLowFloor = Key(midiNumber = 41)
  val TomHighFloor = Key(midiNumber = 43)
  val TomLow = Key(midiNumber = 45)
  val TomLowMid = Key(midiNumber = 47)
  val TomHiMid = Key(midiNumber = 48)
  val TomHigh = Key(midiNumber = 50)

  val DrumAcousticBass = Key(35)
  val DrumBass = Key(36)

  val SnareAcoustic = Key(38)
  val SnareElectric = Key(40)

  val SideStick = Key(37)
  val HandClap = Key(39)

  val HiHatClosed = Key(42)
  val HiHatPedal = Key(44)
  val HiHatOpen = Key(46)

  val CymbalCrash = Key(49)
  val CymbalRide = Key(51)
  val CymbalChinese = Key(52)
  val CymbalSplash = Key(55)
  val CymbalCrash2 = Key(57)
  val CymbalRide2 = Key(59)

  val BongoHi = Key(60)
  val BongoLow = Key(61)

  val CongaMuteHi = Key(62)
  val CongaOpenHi = Key(63)
  val CongaLow = Key(64)

  val CowBell = Key(56)

  val c = Key(midiNumber = 60)
  val d = Key(midiNumber = 62)
  val e = Key(midiNumber = 64)
  val f = Key(midiNumber = 65)
  val g = Key(midiNumber = 67)
  val a = Key(midiNumber = 69)
  val b = Key(midiNumber = 71)

  val p = Pause
  val p1 = Pause(16)
  val p2 = Pause(8)
  val p4 = Pause(4)
  val p8 = Pause(2)
  val p16 = Pause(1)

  val | = Bar

  val cis = c.sharp
  val dis = d.sharp
  val eis = e.sharp
  val fis = f.sharp
  val gis = g.sharp
  val ais = a.sharp

  val ces = c.flat
  val des = d.flat
  val es = e.flat
  val fes = f.flat
  val ges = g.flat
  val as = a.flat
  val bes = b.flat

  val c1 = c.ticks(16)
  val c2 = c.ticks(8)
  val c4 = c.ticks(4)
  val c8 = c.ticks(2)
  val c16 = c.ticks(1)

  val cis1 = cis.ticks(16)
  val cis2 = cis.ticks(8)
  val cis4 = cis.ticks(4)
  val cis8 = cis.ticks(2)
  val cis16 = cis.ticks(1)

  val des1 = des.ticks(16)
  val des2 = des.ticks(8)
  val des4 = des.ticks(4)
  val des8 = des.ticks(2)
  val des16 = des.ticks(1)

  val d1 = d.ticks(16)
  val d2 = d.ticks(8)
  val d4 = d.ticks(4)
  val d8 = d.ticks(2)
  val d16 = d.ticks(1)

  val dis1 = dis.ticks(16)
  val dis2 = dis.ticks(8)
  val dis4 = dis.ticks(4)
  val dis8 = dis.ticks(2)
  val dis16 = dis.ticks(1)

  val es1 = es.ticks(16)
  val es2 = es.ticks(8)
  val es4 = es.ticks(4)
  val es8 = es.ticks(2)
  val es16 = es.ticks(1)

  val e1 = e.ticks(16)
  val e2 = e.ticks(8)
  val e4 = e.ticks(4)
  val e8 = e.ticks(2)
  val e16 = e.ticks(1)

  val eis1 = eis.ticks(16)
  val eis2 = eis.ticks(8)
  val eis4 = eis.ticks(4)
  val eis8 = eis.ticks(2)
  val eis16 = eis.ticks(1)

  val fes1 = fes.ticks(16)
  val fes2 = fes.ticks(8)
  val fes4 = fes.ticks(4)
  val fes8 = fes.ticks(2)
  val fes16 = fes.ticks(1)

  val f1 = f.ticks(16)
  val f2 = f.ticks(8)
  val f4 = f.ticks(4)
  val f8 = f.ticks(2)
  val f16 = f.ticks(1)

  val fis1 = fis.ticks(16)
  val fis2 = fis.ticks(8)
  val fis4 = fis.ticks(4)
  val fis8 = fis.ticks(2)
  val fis16 = fis.ticks(1)

  val ges1 = ges.ticks(16)
  val ges2 = ges.ticks(8)
  val ges4 = ges.ticks(4)
  val ges8 = ges.ticks(2)
  val ges16 = ges.ticks(1)

  val g1 = g.ticks(16)
  val g2 = g.ticks(8)
  val g4 = g.ticks(4)
  val g8 = g.ticks(2)
  val g16 = g.ticks(1)

  val gis1 = gis.ticks(16)
  val gis2 = gis.ticks(8)
  val gis4 = gis.ticks(4)
  val gis8 = gis.ticks(2)
  val gis16 = gis.ticks(1)

  val as1 = as.ticks(16)
  val as2 = as.ticks(8)
  val as4 = as.ticks(4)
  val as8 = as.ticks(2)
  val as16 = as.ticks(1)

  val a1 = a.ticks(16)
  val a2 = a.ticks(8)
  val a4 = a.ticks(4)
  val a8 = a.ticks(2)
  val a16 = a.ticks(1)

  val ais1 = ais.ticks(16)
  val ais2 = ais.ticks(8)
  val ais4 = ais.ticks(4)
  val ais8 = ais.ticks(2)
  val ais16 = ais.ticks(1)

  val bes1 = bes.ticks(16)
  val bes2 = bes.ticks(8)
  val bes4 = bes.ticks(4)
  val bes8 = bes.ticks(2)
  val bes16 = bes.ticks(1)

  val b1 = b.ticks(16)
  val b2 = b.ticks(8)
  val b4 = b.ticks(4)
  val b8 = b.ticks(2)
  val b16 = b.ticks(1)
}

