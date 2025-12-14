package com.sajib.data.utils

import com.sajib.data.model.ApiResponseModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

object ProgressDialogUtils {

    val isProgressDialogShow = MutableSharedFlow<ApiResponseModel>()

    fun showDialog(){
        GlobalScope.launch {
            isProgressDialogShow.emit(ApiResponseModel(true))
        }
    }

    fun disableDialog(){
        GlobalScope.launch {
            isProgressDialogShow.emit(ApiResponseModel(false))
        }
    }
}