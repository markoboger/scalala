/*
 * Copyright 2012 Eric Olander
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.htwg.scalala.midi.events

import javax.sound.midi.MetaMessage

/**
 * Factory object for EndOfTrack meta-message
 */
object EndOfTrack {
  def apply() = {
    val msg = new MetaMessage
    msg.setMessage(0x2F, Array(), 0)
    msg
  }
}