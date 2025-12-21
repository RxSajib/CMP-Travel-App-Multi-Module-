package org.example.project.ui.screen.signupScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.sajib.presentation.ui.signupScreen.SignUpViewModel
import org.example.project.component.BackButton
import org.example.project.component.HeightGap
import org.example.project.component.MyCustomButton
import org.example.project.component.MyCustomInputFiled
import org.example.project.navigation.Destination
import org.example.project.utils.AppLogger
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import travelapp.composeapp.generated.resources.Res
import travelapp.composeapp.generated.resources.already_have_account
import travelapp.composeapp.generated.resources.confirm_password
import travelapp.composeapp.generated.resources.enter_email
import travelapp.composeapp.generated.resources.enter_name
import travelapp.composeapp.generated.resources.enter_password
import travelapp.composeapp.generated.resources.sign_in
import travelapp.composeapp.generated.resources.sign_up_account
import travelapp.composeapp.generated.resources.sign_up_now
import travelapp.composeapp.generated.resources.sign_up_now_details

private const val TAG = "SignUpScreen"
@Composable
fun SignUpScreen(backStack: NavBackStack<NavKey>, key: Destination.SignUpScreen) {

    val viewModel: SignUpViewModel = koinViewModel()
    val data = viewModel.signUpState.collectAsStateWithLifecycle()
    AppLogger.d(tag = TAG, message = "data is ${data.value.data}")

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).verticalScroll(
                rememberScrollState()
            ).padding(16.dp)
        ) {
            BackButton(imageVector = Icons.AutoMirrored.Default.ArrowBack, onclick = {})
            HeightGap(height = 20.dp)
            Text(
                text = stringResource(Res.string.sign_up_now),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.W400
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            HeightGap(height = 10.dp)
            Text(
                text = stringResource(Res.string.sign_up_now_details),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            HeightGap(height = 20.dp)
            MyCustomInputFiled(
                placeHolderText = stringResource(Res.string.enter_name),
                text = viewModel.nameInput,
                onValueChange = { nameInput ->
                    viewModel.nameInput = nameInput
                },
                isPasswordInput = false,
                isVisiblePasswordChange = {},
                isPasswordVisibility = true,
            )
            HeightGap(height = 10.dp)
            MyCustomInputFiled(
                placeHolderText = stringResource(Res.string.enter_email),
                text = viewModel.emailInput,
                onValueChange = { emailInput ->
                    viewModel.emailInput = emailInput
                },
                isPasswordInput = false,
                isVisiblePasswordChange = {},
                isPasswordVisibility = true
            )
            HeightGap(height = 10.dp)
            MyCustomInputFiled(
                placeHolderText = stringResource(Res.string.enter_password),
                text = viewModel.passwordInput,
                onValueChange = { passwordInput ->
                    viewModel.passwordInput = passwordInput
                },
                isPasswordInput = true,
                isVisiblePasswordChange = {
                    viewModel.isPasswordShows.value = !viewModel.isPasswordShows.value
                },
                isPasswordVisibility = viewModel.isPasswordShows.value
            )
            HeightGap(height = 10.dp)
            MyCustomInputFiled(
                placeHolderText = stringResource(Res.string.confirm_password),
                text = viewModel.confirmPasswordInput,
                onValueChange = { conformPasswordInput ->
                    viewModel.confirmPasswordInput = conformPasswordInput
                },
                isPasswordInput = true,
                isVisiblePasswordChange = {
                    viewModel.isConfirmPasswordShows.value = !viewModel.isConfirmPasswordShows.value
                },
                isPasswordVisibility = viewModel.isConfirmPasswordShows.value
            )
            HeightGap(height = 20.dp)
            MyCustomButton(
                title = stringResource(Res.string.sign_up_account),
                modifier = Modifier,
                onClickButton = {
                    viewModel.signUpAccount()
                },
                isEnable = viewModel.isSignUpButtonEnable
            )
            HeightGap(height = 20.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(Res.string.already_have_account),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = stringResource(Res.string.sign_in),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.W500,
                        color = Color.Red,
                    ), modifier = Modifier.clickable {
                        backStack.removeLastOrNull()
                    })
            }
        }
    }
}

