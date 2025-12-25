package org.example.project.ui.screen.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import org.example.project.component.BannerImageSliderItem
import org.example.project.component.HeightGap
import org.example.project.component.MyCustomAppBar
import org.example.project.model.sliderImages
import org.example.project.navigation.Destination
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import travelapp.composeapp.generated.resources.Res
import travelapp.composeapp.generated.resources.explore_all_category
import travelapp.composeapp.generated.resources.habibiYaHabibi
import travelapp.composeapp.generated.resources.view_all

@Composable
fun HomeScreen(backStack: NavBackStack<NavKey>) {
    Scaffold(
        topBar = {
            MyCustomAppBar(
                isActonButtonEnable = true,
                isBackButtonEnable = false,
                title = stringResource(Res.string.habibiYaHabibi),
                homeHeaderEnable = true,
                onBackPress = {}
            )
        },
        modifier = Modifier.background(MaterialTheme.colorScheme.surface)
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
        ) {
            HeightGap(15.dp)
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(sliderImages){
                    BannerImageSliderItem(image = it.image)
                }
            }
            HeightGap(15.dp)
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = stringResource(Res.string.explore_all_category),
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = MaterialTheme.colorScheme.primary
                    )
                )
                Text(
                    text = stringResource(Res.string.view_all),
                    modifier = Modifier.clickable{
                        backStack.add(Destination.CategoryScreen)
                    }
                )
            }
            HeightGap(15.dp)
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {

}