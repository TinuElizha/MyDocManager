package com.tinz.mydocmanager.ui.screens.common_widgets

import android.content.res.Configuration
import android.graphics.drawable.PaintDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tinz.mydocmanager.R
import com.tinz.mydocmanager.ui.theme.AppTheme

@Composable
fun UploadViewCommon(upLoadImgText:String?){
    Column( modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(R.drawable.upload) , contentDescription ="upload_image" )
        upLoadImgText?.let { Text(text = it, color = Color.Black) }
    }
}
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun UploadViewLight() {
    AppTheme {
        UploadViewCommon(null)
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun UploadViewDark() {
    AppTheme {
        UploadViewCommon(null)
    }
}