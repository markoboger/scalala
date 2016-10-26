package de.htwg.scalala

package object music {

  def play(elems: MusicElem*): Unit = elems.map(elem => elem.play)
  def play(seq: MusicSeq): Unit = seq.map { elem => elem.play }
 
  val Piano = Instrument(name = "Piano", program = 0)
  val Marimba = Instrument(name = "Marimba", program = 13)
  val Xylophone = Instrument(name = "Xylophone", program = 14)
  val Organ = Instrument(name = "Organ", program = 20)
  val Guitar = Instrument(name = "Guitar", program = 25)
  val Bass = Instrument(name = "Bass", program = 33)
  val Violin = Instrument(name = "Violin", program = 41)
  val Cello = Instrument(name = "Cello", program = 43)
  val Trumpet = Instrument(name = "Trumpet", program = 57)
  val Tuba = Instrument(name = "Tuba", program = 59)
  val Horn = Instrument(name = "Horn", program = 61)
  val Sax = Instrument(name = "Sax", program = 68)
  val Oboe = Instrument(name = "Oboe", program = 69)
  val Clarinet = Instrument(name = "Clarinet", program = 72)
  val Flute = Instrument(name = "Flute", program = 74)

  val c = Key(midiNumber = 60)
  val d = Key(midiNumber = 62)
  val e = Key(midiNumber = 64)
  val f = Key(midiNumber = 65)
  val g = Key(midiNumber = 67)
  val a = Key(midiNumber = 69)
  val b = Key(midiNumber = 71)

  val p = Pause
  val p1 = Pause(1.0)
  val p2 = Pause(0.5)
  val p4 = Pause(0.25)
  val p8 = Pause(0.125)
  val p16 = Pause(0.0625)

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

  val c1 = c.speed(1.0)
  val c2 = c.speed(0.5)
  val c4 = c.speed(0.25)
  val c8 = c.speed(0.125)
  val c16 = c.speed(0.0625)

  val cis1 = cis.speed(1.0)
  val cis2 = cis.speed(0.5)
  val cis4 = cis.speed(0.25)
  val cis8 = cis.speed(0.125)
  val cis16 = cis.speed(0.0625)

  val des1 = des.speed(1.0)
  val des2 = des.speed(0.5)
  val des4 = des.speed(0.25)
  val des8 = des.speed(0.125)
  val des16 = des.speed(0.0625)

  val d1 = d.speed(1.0)
  val d2 = d.speed(0.5)
  val d4 = d.speed(0.25)
  val d8 = d.speed(0.125)
  val d16 = d.speed(0.0625)

  val dis1 = dis.speed(1.0)
  val dis2 = dis.speed(0.5)
  val dis4 = dis.speed(0.25)
  val dis8 = dis.speed(0.125)
  val dis16 = dis.speed(0.0625)

  val es1 = es.speed(1.0)
  val es2 = es.speed(0.5)
  val es4 = es.speed(0.25)
  val es8 = es.speed(0.125)
  val es16 = es.speed(0.0625)

  val e1 = e.speed(1.0)
  val e2 = e.speed(0.5)
  val e4 = e.speed(0.25)
  val e8 = e.speed(0.125)
  val e16 = e.speed(0.0625)

  val eis1 = eis.speed(1.0)
  val eis2 = eis.speed(0.5)
  val eis4 = eis.speed(0.25)
  val eis8 = eis.speed(0.125)
  val eis16 = eis.speed(0.0625)

  val fes1 = fes.speed(1.0)
  val fes2 = fes.speed(0.5)
  val fes4 = fes.speed(0.25)
  val fes8 = fes.speed(0.125)
  val fes16 = fes.speed(0.0625)

  val f1 = f.speed(1.0)
  val f2 = f.speed(0.5)
  val f4 = f.speed(0.25)
  val f8 = f.speed(0.125)
  val f16 = f.speed(0.0625)

  val fis1 = fis.speed(1.0)
  val fis2 = fis.speed(0.5)
  val fis4 = fis.speed(0.25)
  val fis8 = fis.speed(0.125)
  val fis16 = fis.speed(0.0625)

  val ges1 = ges.speed(1.0)
  val ges2 = ges.speed(0.5)
  val ges4 = ges.speed(0.25)
  val ges8 = ges.speed(0.125)
  val ges16 = ges.speed(0.0625)

  val g1 = g.speed(1.0)
  val g2 = g.speed(0.5)
  val g4 = g.speed(0.25)
  val g8 = g.speed(0.125)
  val g16 = g.speed(0.0625)

  val gis1 = gis.speed(1.0)
  val gis2 = gis.speed(0.5)
  val gis4 = gis.speed(0.25)
  val gis8 = gis.speed(0.125)
  val gis16 = gis.speed(0.0625)

  val as1 = as.speed(1.0)
  val as2 = as.speed(0.5)
  val as4 = as.speed(0.25)
  val as8 = as.speed(0.125)
  val as16 = as.speed(0.0625)

  val a1 = a.speed(1.0)
  val a2 = a.speed(0.5)
  val a4 = a.speed(0.25)
  val a8 = a.speed(0.125)
  val a16 = a.speed(0.0625)

  val ais1 = ais.speed(1.0)
  val ais2 = ais.speed(0.5)
  val ais4 = ais.speed(0.25)
  val ais8 = ais.speed(0.125)
  val ais16 = ais.speed(0.0625)

  val bes1 = bes.speed(1.0)
  val bes2 = bes.speed(0.5)
  val bes4 = bes.speed(0.25)
  val bes8 = bes.speed(0.125)
  val bes16 = bes.speed(0.0625)

  val b1 = b.speed(1.0)
  val b2 = b.speed(0.5)
  val b4 = b.speed(0.25)
  val b8 = b.speed(0.125)
  val b16 = b.speed(0.0625)
}

