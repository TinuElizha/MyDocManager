package com.tinz.mydocmanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tinz.mydocmanager.ui.screens.bottom_screens.ImageScannerScreen
import com.tinz.mydocmanager.ui.screens.bottom_screens.MyDocScreen
import com.tinz.mydocmanager.ui.screens.pdf.PdfConverterScreen
import com.tinz.mydocmanager.ui.screens.pdf.PdfViewModel

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Pdf.route
    ) {
        composable(route = BottomBarScreen.Pdf.route) {
            PdfConverterScreen(viewModel = PdfViewModel(),navController)
        }
        composable(route = BottomBarScreen.Image.route) {
            ImageScannerScreen()
        }
        composable(route = BottomBarScreen.MyDoc.route) {
            MyDocScreen()
        }
    }
}