package org.example.project.ui.screen.signupScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sajib.presentation.ui.signupScreen.SignUpViewModel
import org.example.project.component.BackButton
import org.example.project.component.HeightGap
import org.example.project.component.MyCustomInputFiled
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import travelapp.composeapp.generated.resources.Res
import travelapp.composeapp.generated.resources.enter_email
import travelapp.composeapp.generated.resources.sign_in_now_details
import travelapp.composeapp.generated.resources.sign_up_now
import travelapp.composeapp.generated.resources.sign_up_now_details

@Composable
fun SignUpScreen(){

    val viewModel : SignUpViewModel = koinViewModel()

    Scaffold { innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding).padding(16.dp)) {
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
                placeHolderText = stringResource(Res.string.enter_email),
                text = viewModel.nameInput,
                onValueChange = { nameInput ->
                    viewModel.nameInput = nameInput
                },
                isPasswordInput = false,
                isVisiblePasswordChange = {},
                isPasswordVisibility = true
            )
            HeightGap(height = 10.dp)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SignUpScreenPreview(){
    SignUpScreen()
}