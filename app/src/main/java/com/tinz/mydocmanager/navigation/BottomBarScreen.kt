package com.tinz.mydocmanager.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import com.tinz.mydocmanager.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Pdf : BottomBarScreen(
        route = "pdf_converter",
        title = "PDF",
        icon = R.drawable.pdf
    )

    object Image : BottomBarScreen(
        route = "image",
        title = "Image",
        icon = R.drawable.picture
    )

    object MyDoc : BottomBarScreen(
        route = "my_doc",
        title = "MyDoc",
        icon = R.drawable.documents
    )
}