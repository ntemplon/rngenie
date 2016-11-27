package com.rngenie

import com.rngenie.ui.MainView
import tornadofx.App

/**
 * Created by nathan on 8/24/16.
 */
class RNGenie : App() {
    override val primaryView = MainView::class

    companion object {
        val APPLICATION_NAME: String = "RNGenie"

        val MAJOR_VERSION: Int = 0
        val MINOR_VERSION: Int = 0
        val REVISION: Int = 0
        val APPLICATION_VERSION: String = "$MAJOR_VERSION.$MINOR_VERSION.$REVISION"

        val APPLICATION_TITLE: String = "$APPLICATION_NAME v$APPLICATION_VERSION"
    }
}