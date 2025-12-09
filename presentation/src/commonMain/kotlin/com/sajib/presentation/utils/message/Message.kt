package com.sajib.presentation.utils.message

import androidx.compose.ui.graphics.Color
import multiplatform.network.cmptoast.showToast

fun showMessage(message : String){
    showToast(
        message = message,
        cornerRadius = 10,
        backgroundColor = Color.Red,
        textColor = Color.White
    )
}