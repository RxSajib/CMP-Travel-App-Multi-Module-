package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sajib.data.model.ApiResponseModel
import com.sajib.data.utils.ProgressDialogUtils
import com.sajib.presentation.listing.TravelListingViewModel
import org.example.project.component.dialog.ProgressDialog
import org.example.project.navigation.AppNavigation
import org.example.project.ui.theme.AppTheme
import org.example.project.utils.AppLogger
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

private const val TAG = "App"
@Composable
@Preview
fun App() {

    AppTheme {

        val viewModel: TravelListingViewModel = koinViewModel<TravelListingViewModel>()

        val showDialog = ProgressDialogUtils.isProgressDialogShow.collectAsStateWithLifecycle(
            ApiResponseModel(false)
        )

        AppLogger.d(tag = TAG, message = "${showDialog.value.response}")


        //  SignInScreen()
        AppNavigation()

        if(showDialog.value.response){
            ProgressDialog { showDialog.value.response }
        }
    }
}