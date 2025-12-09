package org.example.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import multiplatform.network.cmptoast.ToastHost
import org.example.project.di.initKoin

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Travel App",
    ) {
        App()
        ToastHost()
    }
}