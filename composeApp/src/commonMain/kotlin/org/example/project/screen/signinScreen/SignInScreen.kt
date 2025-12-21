package org.example.project.screen.signinScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.sajib.presentation.ui.signInScreen.SignInViewModel
import org.example.project.component.BackButton
import org.example.project.component.HeightGap
import org.example.project.component.MyCustomButton
import org.example.project.component.MyCustomInputFiled
import org.example.project.navigation.Destination
import org.example.project.utils.AppLogger
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import travelapp.composeapp.generated.resources.Res
import travelapp.composeapp.generated.resources.dont_have_an_account
import travelapp.composeapp.generated.resources.enter_email
import travelapp.composeapp.generated.resources.enter_password
import travelapp.composeapp.generated.resources.forgot_password
import travelapp.composeapp.generated.resources.sign_in_account
import travelapp.composeapp.generated.resources.sign_in_now
import travelapp.composeapp.generated.resources.sign_in_now_details
import travelapp.composeapp.generated.resources.sign_up

private const val TAG = "SignInScreen"
@Composable
fun SignInScreen(backStack: NavBackStack<NavKey>) {

    val viewModel: SignInViewModel = koinViewModel()

    AppLogger.d(tag = TAG, message = viewModel.isButtonEnableForSignIn.toString())

    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize().padding(16.dp).verticalScroll(state = rememberScrollState())) {
            BackButton(imageVector = Icons.AutoMirrored.Default.ArrowBack, onclick = {})

            HeightGap(height = 20.dp)
            Text(
                text = stringResource(Res.string.sign_in_now),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.W400
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            HeightGap(height = 10.dp)
            Text(
                text = stringResource(Res.string.sign_in_now_details),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            HeightGap(height = 20.dp)

            MyCustomInputFiled(
                placeHolderText = stringResource(Res.string.enter_email),
                text = viewModel.inputEmailAddressInput,
                onValueChange = { emailAddressInput ->
                    viewModel.inputEmailAddressInput = emailAddressInput
                    viewModel.onEmailChanged(emailAddressInput)
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
                    viewModel.isPasswordVisible = !viewModel.isPasswordVisible
                },
                isPasswordVisibility = viewModel.isPasswordVisible
            )
            HeightGap(height = 5.dp)
            Row {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = stringResource(Res.string.forgot_password),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.clickable {

                    })
            }
            HeightGap(height = 20.dp)
            MyCustomButton(
                title = stringResource(Res.string.sign_in_account),
                modifier = Modifier,
                onClickButton = {},
                isEnable = viewModel.isButtonEnableForSignIn)

            HeightGap(height = 20.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(Res.string.dont_have_an_account),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = stringResource(Res.string.sign_up),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.W500,
                        color = Color.Red,
                    ), modifier = Modifier.clickable {
                        backStack.add(element = Destination.SignUpScreen())
                    })
            }
        }

    }
}

