package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sajib.data.datasources.DummyDataSource
import com.sajib.data.model.ApiResponseModel
import com.sajib.data.repository.TravelingListingImpl
import com.sajib.data.utils.ProgressDialogUtils
import com.sajib.domain.model.TravelingListing
import com.sajib.domain.usecase.GetAllListingUseCase
import com.sajib.presentation.listing.TravelListingViewModel
import org.example.project.component.MyTravelItem
import org.example.project.component.dialog.ProgressDialog
import org.example.project.navigation.AppNavigation
import org.example.project.screen.TravelScreen
import org.example.project.screen.signinScreen.SignInScreen
import org.example.project.ui.screen.signupScreen.SignUpScreen
import org.example.project.utils.AppLogger
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

import travelapp.composeapp.generated.resources.Res
import travelapp.composeapp.generated.resources.compose_multiplatform

private const val TAG = "App"
@Composable
@Preview
fun App() {

    MaterialTheme {

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