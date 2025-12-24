package org.example.project.ui.screen.homeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.example.project.component.MyCustomAppBar
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import travelapp.composeapp.generated.resources.Res
import travelapp.composeapp.generated.resources.habibiYaHabibi

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            MyCustomAppBar(
                isActonButtonEnable = true,
                isBackButtonEnable = false,
                title = stringResource(Res.string.habibiYaHabibi),
                homeHeaderEnable = true
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}