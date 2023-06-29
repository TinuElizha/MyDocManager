package com.tinz.mydocmanager.ui.screens.common_widgets

import android.content.res.Configuration
import android.graphics.drawable.PaintDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun UploadViewCommon(upLoadImgText:String?, onClickImage: ()-> Unit){
    Column( modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(painter = painterResource(R.drawable.upload) , contentDescription ="upload_image",
            modifier = Modifier.clickable(onClick = onClickImage))
        upLoadImgText?.let { Text(text = it, color = Color.Black) }
    }
}
