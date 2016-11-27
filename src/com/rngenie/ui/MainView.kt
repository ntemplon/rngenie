package com.rngenie.ui

import com.rngenie.RNGenie
import com.rngenie.rng.EmeraldRng
import com.rngenie.ui.OkCancelApplyPanel.Companion.okCancelApplyPane
import com.rngenie.ui.SingleButtonPanel.Companion.buttonPanel
import com.rngenie.ui.controls.EmeraldRngControl.Companion.emeraldRngControl
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Alert
import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import tornadofx.*
import tornadofx.Stylesheet.Companion.textField


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
class MainView : View() {
    override val root = BorderPane()

    private val rng = EmeraldRng(0x1A56B091)

    init {
        title = RNGenie.APPLICATION_TITLE

        with (root) {
            padding = Insets(20.0)
            prefWidth = 700.0
            prefHeight = 500.0

            center {
                emeraldRngControl(rng) {

                }
            }

            bottom {
                buttonPanel("Close") {
                    action = { this.closeWindow() }
                }
            }
        }
    }

    private fun sayHello() {
        alert(Alert.AlertType.INFORMATION) {
            title = "Message"
            headerText = "Computer Greeting"
            contentText = "Hello World!"
        }.showAndWait()
    }
}