package org.example.project.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import travelapp.composeapp.generated.resources.Res
import travelapp.composeapp.generated.resources.compose_multiplatform
import travelapp.composeapp.generated.resources.image_placeholder

@Composable
fun BannerImageSliderItem(image: String) {
    AsyncImage(
        model = image,
        modifier = Modifier.height(170.dp).padding(horizontal = 16.dp).fillMaxWidth(1f)
            .clip(shape = RoundedCornerShape(10.dp)),
        placeholder = painterResource(Res.drawable.image_placeholder),
        error = painterResource(Res.drawable.image_placeholder),
        contentDescription = null,
        contentScale = ContentScale.Fit
    )
}

@Composable
@Preview
fun BannerImageSliderItemPreview() {
    BannerImageSliderItem(image = "")
}