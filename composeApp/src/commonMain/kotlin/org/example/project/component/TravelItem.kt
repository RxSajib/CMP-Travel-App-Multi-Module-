package org.example.project.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.sajib.domain.model.TravelingListing
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import travelapp.composeapp.generated.resources.Res
import travelapp.composeapp.generated.resources.compose_multiplatform

@Composable
fun MyTravelItem(travelingListing: TravelingListing, onclick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth().clickable { onclick.invoke() }
        .background(color = Color.Blue.copy(alpha = .1f)).padding(10.dp)
        .clip(shape = RoundedCornerShape(16.dp))) {
         AsyncImage(
             model = travelingListing.imageUri,
             modifier = Modifier.size(80.dp),
             placeholder = painterResource(Res.drawable.compose_multiplatform),
             error = painterResource(Res.drawable.compose_multiplatform),
             contentDescription = null,
             contentScale = ContentScale.Fit
         )

        Column(modifier = Modifier.weight(1f).padding(start = 10.dp)) {
            Text(
                text = travelingListing.title,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.Black, fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = travelingListing.details,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodySmall.copy(color = Color.Black.copy(alpha = .4f))
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                travelingListing.ametites.forEach { data ->
                    Text(
                        text = data,
                        modifier = Modifier.padding(end = 10.dp).clip(shape = CircleShape)
                            .background(color = Color.Gray.copy(alpha = .4f)).padding(10.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MyTravelItemPreview() {
    MyTravelItem(
        travelingListing = TravelingListing(
            id = "1",
            title = "Seaside Paradise Resort",
            details = "Beautiful ocean view resort with private beach access.",
            location = "Cox’s Bazar, Bangladesh",
            imageUri = "https://example.com/img1.jpg",
            priceParNight = 4500.0,
            rating = 4.8,
            ametites = listOf("WiFi", "Pool", "Breakfast"),
            hostName = "Rahim",
            isFavorite = false
        ), onclick = {})
}