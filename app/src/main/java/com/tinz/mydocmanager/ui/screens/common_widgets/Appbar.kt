package com.tinz.mydocmanager.ui.screens.common_widgets

import android.content.res.Configuration
import android.media.Image
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material.*
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tinz.mydocmanager.ui.theme.spacing
import com.tinz.mydocmanager.R
import com.tinz.mydocmanager.ui.theme.AppTheme

@Composable
fun AppbarCommon() {
    val systemUiController = rememberSystemUiController()

    if( Configuration.UI_MODE_NIGHT_NO.equals(true)){
        systemUiController.setSystemBarsColor(
            color = Color.Transparent
        )
    }else{
        systemUiController.setSystemBarsColor(
            color =  MaterialTheme.colorScheme.primary
        )
    }
    val contextForToast = LocalContext.current.applicationContext

    TopAppBar(backgroundColor = MaterialTheme.colorScheme.primary,


        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                color =  MaterialTheme.colorScheme.onPrimary
            )
        },

        actions = {

            // lock icon
            TopAppBarActionButton(
                imageVector = Icons.Outlined.MoreVert,
                description = "More"
            ) {
                Toast.makeText(contextForToast, "More Click", Toast.LENGTH_SHORT)
                    .show()
            }
        },


    )

}

@Composable
fun TopAppBarActionButton(
    imageVector: ImageVector,
    description: String,
    onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(imageVector = imageVector, contentDescription = description)
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AppHeaderLight() {
    AppTheme {
        AppbarCommon()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AppHeaderDark() {
    AppTheme {
        AppbarCommon()
    }
}
