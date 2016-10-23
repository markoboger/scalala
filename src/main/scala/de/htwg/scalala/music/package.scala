package de.htwg.scalala

package object music {
  def play(key: Key): String = key.play
  def play(keys: Key*): Seq[String] = keys.map(key => play(key))
  def play(keys: List[Key]): List[String] = keys.map(key => play(key))
  def play(tuple: Product): Unit = Chord(tuple.productIterator.toSet.map { key: Any => key.asInstanceOf[Key] }).play
  def play(chord: Chord): Unit = chord.play
  def play(chords: List[Chord]): Unit = chords.map(chord => chord.play)

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

  def c = Key(keynumber = 0)
  def d = Key(keynumber = 2)
  def e = Key(keynumber = 4)
  def f = Key(keynumber = 5)
  def g = Key(keynumber = 7)
  def a = Key(keynumber = 9)
  def b = Key(keynumber = 11)

  def cis = c.sharp
  def dis = d.sharp
  def eis = e.sharp
  def fis = f.sharp
  def gis = g.sharp
  def ais = a.sharp

  def ces = c.flat
  def des = d.flat
  def es = e.flat
  def fes = f.flat
  def ges = g.flat
  def as = a.flat

  def c1 = c.speed(1.0)
  def c2 = c.speed(0.5)
  def c4 = c.speed(0.25)
  def c8 = c.speed(0.125)
  def c16 = c.speed(0.0625)

  def cis1 = cis.speed(1.0)
  def cis2 = cis.speed(0.5)
  def cis4 = cis.speed(0.25)
  def cis8 = cis.speed(0.125)
  def cis16 = cis.speed(0.0625)

  def des1 = des.speed(1.0)
  def des2 = des.speed(0.5)
  def des4 = des.speed(0.25)
  def des8 = des.speed(0.125)
  def des16 = des.speed(0.0625)

  def d1 = d.speed(1.0)
  def d2 = d.speed(0.5)
  def d4 = d.speed(0.25)
  def d8 = d.speed(0.125)
  def d16 = d.speed(0.0625)

  def dis1 = dis.speed(1.0)
  def dis2 = dis.speed(0.5)
  def dis4 = dis.speed(0.25)
  def dis8 = dis.speed(0.125)
  def dis16 = dis.speed(0.0625)

  def es1 = es.speed(1.0)
  def es2 = es.speed(0.5)
  def es4 = es.speed(0.25)
  def es8 = es.speed(0.125)
  def es16 = es.speed(0.0625)

  def e1 = e.speed(1.0)
  def e2 = e.speed(0.5)
  def e4 = e.speed(0.25)
  def e8 = e.speed(0.125)
  def e16 = e.speed(0.0625)

  def eis1 = eis.speed(1.0)
  def eis2 = eis.speed(0.5)
  def eis4 = eis.speed(0.25)
  def eis8 = eis.speed(0.125)
  def eis16 = eis.speed(0.0625)

  def fes1 = fes.speed(1.0)
  def fes2 = fes.speed(0.5)
  def fes4 = fes.speed(0.25)
  def fes8 = fes.speed(0.125)
  def fes16 = fes.speed(0.0625)

  def f1 = f.speed(1.0)
  def f2 = f.speed(0.5)
  def f4 = f.speed(0.25)
  def f8 = f.speed(0.125)
  def f16 = f.speed(0.0625)

  def fis1 = fis.speed(1.0)
  def fis2 = fis.speed(0.5)
  def fis4 = fis.speed(0.25)
  def fis8 = fis.speed(0.125)
  def fis16 = fis.speed(0.0625)

  def ges1 = ges.speed(1.0)
  def ges2 = ges.speed(0.5)
  def ges4 = ges.speed(0.25)
  def ges8 = ges.speed(0.125)
  def ges16 = ges.speed(0.0625)

  def g1 = g.speed(1.0)
  def g2 = g.speed(0.5)
  def g4 = g.speed(0.25)
  def g8 = g.speed(0.125)
  def g16 = g.speed(0.0625)

  def gis1 = gis.speed(1.0)
  def gis2 = gis.speed(0.5)
  def gis4 = gis.speed(0.25)
  def gis8 = gis.speed(0.125)
  def gis16 = gis.speed(0.0625)

  def as1 = as.speed(1.0)
  def as2 = as.speed(0.5)
  def as4 = as.speed(0.25)
  def as8 = as.speed(0.125)
  def as16 = as.speed(0.0625)

  def a1 = a.speed(1.0)
  def a2 = a.speed(0.5)
  def a4 = a.speed(0.25)
  def a8 = a.speed(0.125)
  def a16 = a.speed(0.0625)

  def ais1 = ais.speed(1.0)
  def ais2 = ais.speed(0.5)
  def ais4 = ais.speed(0.25)
  def ais8 = ais.speed(0.125)
  def ais16 = ais.speed(0.0625)

  def b1 = b.speed(1.0)
  def b2 = b.speed(0.5)
  def b4 = b.speed(0.25)
  def b8 = b.speed(0.125)
  def b16 = b.speed(0.0625)

  implicit class KeyList(keys: List[Key]) {
    def play: Seq[String] = music.play(keys)
    def play(instrument: Instrument): Seq[String] = instrument.play(keys)
  }
  implicit class ChordList(chords: List[Chord]) {
    def play: Unit = music.play(chords)
    def play(instrument: Instrument): Unit = instrument.play(chords)
  }
}

