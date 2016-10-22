package de.htwg.scalala.music

import notes._
import chords._
import player._
import scala.language.postfixOps

 
object MusicWorksheet {
  
  val c = Key(0,4)                                //> c  : de.htwg.scalala.music.Key = c¼
  c.toString                                      //> res0: String = c¼

  c.duration                                      //> res1: Int = 750
 
      
  c+                                              //> res2: de.htwg.scalala.music.Key = c'¼
     
  c++                                             //> res3: de.htwg.scalala.music.Key = c"¼
  
  c-                                              //> res4: de.htwg.scalala.music.Key = c,¼
    
  c--                                             //> res5: de.htwg.scalala.music.Key = c,,¼
    
  c!                                              //> res6: de.htwg.scalala.music.Key = c¼
  
  c?                                              //> res7: de.htwg.scalala.music.Key = c¼
  
  c4.toString                                     //> res8: String = c¼
  c1.toString                                     //> res9: String = c
 
  play((c,e,g))                                   //> res10: <error> = Set(c¼, e¼, g¼)
  play((d,f,a))                                   //> res11: <error> = Set(d¼, f¼, a¼)
  play(Cdur)                                      //> res12: <error> = Set(c¼, e¼, g¼)
  play((c-,c,e,g,c+,e+ ))                         //> res13: <error> = Set(c'¼, e'¼, g¼, e¼, c¼, c,¼)
  play(c4!)                                       //> res14: <error> = c¼
  play(d4?)                                       //> res15: <error> = d¼
  play(List(c!,d,e,f!,g?, a, b))                  //> res16: <error> = List(c¼, d¼, e¼, f¼, g¼, a¼, b¼)
  play(List(c1, d4,d4,e2))                        //> res17: <error> = List(c, d¼, d¼, e½)
  
  
}