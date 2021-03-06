package com.rngenie.ui.controls

import com.rngenie.rng.EmeraldRng
import com.rngenie.util.toHexString
import javafx.beans.property.SimpleStringProperty
import javafx.event.EventTarget
import javafx.scene.Parent
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import tornadofx.*
import tornadofx.Stylesheet.Companion.text
import java.util.*

/**
 * Copyright (c) 2016 Nathan Templon
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
class EmeraldRngControl(private val rng: EmeraldRng) : GridPane() {
    private val seedProp = SimpleStringProperty()
    private val randProp = SimpleStringProperty()

    init {
            row {
                label("Seed:") { }
                label(seedProp) { }
            }
            row {
                label("Random Number:") { }
                label(randProp) { }
            }
            row {
                label("") { }
                button("Advance").setOnAction {
                    seedProp.value = rng.seed.toHexString().padStart(8, '0').toUpperCase(Locale.US)
                    randProp.value = rng.next().toHexString().padStart(4, '0').toUpperCase(Locale.US)
                }
            }
    }

    companion object {
        fun EventTarget.emeraldRngControl(rng: EmeraldRng, op: EmeraldRngControl.() -> Unit) {
            val cntl = EmeraldRngControl(rng)
            opcr(this, cntl, op)
        }
    }
}