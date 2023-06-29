package com.tinz.mydocmanager.ui.screens.common_widgets

import android.content.res.Configuration
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.tinz.mydocmanager.ui.screens.pdf.PdfConverterScreen
import com.tinz.mydocmanager.ui.screens.pdf.PdfViewModel
import com.tinz.mydocmanager.ui.theme.AppTheme

@Composable
fun ImagePreviewItem(
    uri: Uri,
    height: Dp,
    width: Dp,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .fillMaxWidth()
            .background(Color.White)

    ) {
        AsyncImage(
            model = uri,
            contentDescription = "",
            modifier = Modifier
                .width(width)
                .height(height),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(5.dp))

        IconButton(onClick = { onClick() }) {
            Icon(imageVector = Icons.Default.Delete,
                contentDescription = "",
                modifier = Modifier
                    .size(25.dp).align(Alignment.BottomCenter),
                tint = Color.White,

            )
        }
    }
}
