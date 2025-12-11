package org.example.project.screen.signinScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sajib.presentation.signInScreen.SignInViewModel
import org.example.project.component.BackButton
import org.example.project.component.HeightGap
import org.example.project.component.MyCustomButton
import org.example.project.component.MyCustomInputFiled
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SignInScreen() {

    val viewModel: SignInViewModel = koinViewModel()

    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize().padding(16.dp)) {
            BackButton(imageVector = Icons.AutoMirrored.Default.ArrowBack, onclick = {})

            HeightGap(height = 20.dp)
            Text(
                text = "Sign In Now",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.W400
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            HeightGap(height = 10.dp)
            Text(
                text = "Please sign in to continue our app",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            HeightGap(height = 20.dp)

            MyCustomInputFiled(
                placeHolderText = "Enter email", text = viewModel.inputEmailAddressInput,
                onValueChange = { emailAddressInput ->
                    viewModel.inputEmailAddressInput = emailAddressInput
                },
                isPasswordInput = false,
                isVisiblePasswordChange = {},
                isPasswordVisibility = true
            )
            HeightGap(height = 10.dp)
            MyCustomInputFiled(
                placeHolderText = "Enter password", text = viewModel.passwordInput,
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
                    text = "Forgot password?",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.clickable {

                    })
            }
            HeightGap(height = 20.dp)
            MyCustomButton(title = "Sign In Account", modifier = Modifier, onClickButton = {})

            HeightGap(height = 20.dp)
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Don't have an account ",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Sign Up",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.W500,
                        color = Color.Red,
                ), modifier = Modifier.clickable{})
            }
        }

    }
}

@Composable
@Preview
fun SignInScreenPreview() {
    SignInScreen()
}