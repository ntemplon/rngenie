package com.rngenie.ui

import javafx.event.ActionEvent
import javafx.event.EventTarget
import javafx.geometry.Pos
import javafx.scene.layout.HBox
import tornadofx.button
import tornadofx.opcr

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
class SingleButtonPanel(text: String) : HBox() {
    var action: (ActionEvent) -> Unit = { }

    init {
        alignment = DEFAULT_ALIGNMENT
        spacing = DEFAULT_SPACING

        button(text).setOnAction { e -> action.invoke(e) }
    }

    companion object {
        fun EventTarget.buttonPanel(text: String, op: SingleButtonPanel.() -> Unit) {
            val pane = SingleButtonPanel(text)
            opcr(this, pane, op)
        }

        val DEFAULT_ALIGNMENT: Pos = Pos.BASELINE_RIGHT
        val DEFAULT_SPACING: Double = 10.0
    }
}

class OkCancelApplyPanel : HBox() {
    var okAction: (ActionEvent) -> Unit = { }
    var cancelAction: (ActionEvent) -> Unit = { }
    var applyAction: (ActionEvent) -> Unit = { }

    init {
        alignment = DEFAULT_ALIGNMENT
        spacing = DEFAULT_SPACING

        button("OK").setOnAction { e -> okAction.invoke(e) }
        button("Cancel").setOnAction { e -> cancelAction.invoke(e) }
        button("Apply").setOnAction { e -> applyAction.invoke(e) }
    }

    companion object {
        fun EventTarget.okCancelApplyPane(op: OkCancelApplyPanel.() -> Unit) {
            val pane = OkCancelApplyPanel()
            opcr(this, pane, op)
        }

        val DEFAULT_ALIGNMENT: Pos = Pos.BASELINE_RIGHT
        val DEFAULT_SPACING: Double = 10.0
    }
}