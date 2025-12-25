package org.example.project.ui.screen.category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.sajib.presentation.ui.categoryScreen.CategoryViewModel
import org.example.project.component.CategoryItem
import org.example.project.component.MyCustomAppBar
import org.example.project.navigation.Destination
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import travelapp.composeapp.generated.resources.Res
import travelapp.composeapp.generated.resources.all_category

@Composable
fun CategoryScreen(backStack: NavBackStack<NavKey>) {

    val viewModel : CategoryViewModel = koinViewModel()


    Scaffold(
        topBar = {
            MyCustomAppBar(title = stringResource(Res.string.all_category), onBackPress = {backStack.remove(
                Destination.CategoryScreen)})
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding).fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            LazyVerticalGrid(columns = GridCells.Fixed(3)){
                items(10){
                    CategoryItem()
                }
            }
        }
    }
}