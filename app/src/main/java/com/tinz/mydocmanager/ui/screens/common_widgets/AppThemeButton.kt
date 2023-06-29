package com.tinz.mydocmanager.ui.screens.common_widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tinz.mydocmanager.R

@Composable
fun AppThemedButton( onClick: () -> Unit,paddingAll: Dp?,textColor:Color?,textLabel:String)
{
    val textLabelValue = if (textLabel!=null) textLabel else ""
    val paddingAllValue = if (paddingAll!=null) paddingAll else 20.dp
    val textColorValue = if (textColor!=null) textColor else Color.White


    Button(colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colorScheme.primary),
        onClick = { onClick() }, modifier = Modifier.padding(paddingAllValue).fillMaxWidth()) {
        Text(text = textLabelValue, color = textColorValue,textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterVertically))
    }
}