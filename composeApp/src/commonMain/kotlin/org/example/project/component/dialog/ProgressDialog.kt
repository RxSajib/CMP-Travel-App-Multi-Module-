package org.example.project.component.dialog

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ProgressDialog(onDismissRequest: () -> Unit){
    Dialog(onDismissRequest = {onDismissRequest.invoke()}, content = {
        Card(shape = CircleShape, modifier = Modifier) {
            CircularProgressIndicator(modifier = Modifier.padding(10.dp).size(20.dp))
        }
    })
}

@Composable
@Preview
fun ProgressDialogPreview(){
    ProgressDialog(onDismissRequest = {})
}