package org.example.project.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sajib.presentation.listing.TravelListingViewModel
import com.sajib.presentation.utils.message.showMessage
import multiplatform.network.cmptoast.showToast
import org.example.project.component.MyTravelItem

@Composable
fun TravelScreen(viewModel : TravelListingViewModel){

    val listOfTravelingListing = viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold {innerPadding ->
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            if(listOfTravelingListing.value.isLoading){
                CircularProgressIndicator()
            }else {
                LazyColumn(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface).padding(innerPadding)) {
                    items(listOfTravelingListing.value.data){item ->
                        MyTravelItem(travelingListing = item, onclick = {
                            showMessage(message = item.getRatingDescriptions())
                        })
                    }
                }
            }

        }

    }
}