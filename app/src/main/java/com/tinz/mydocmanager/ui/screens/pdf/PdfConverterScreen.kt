package com.tinz.mydocmanager.ui.screens.pdf

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.tinz.mydocmanager.R
import com.tinz.mydocmanager.ui.screens.common_widgets.AppbarCommon
import com.tinz.mydocmanager.ui.screens.common_widgets.UploadViewCommon
import com.tinz.mydocmanager.ui.theme.AppTheme
import com.tinz.mydocmanager.ui.theme.spacing

@Composable
fun PdfConverterScreen(viewModel: PdfViewModel?,navController: NavController?) {

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        AppbarCommon()
        UploadViewCommon(stringResource(id = R.string.test_pdf_upload))
        val spacing = MaterialTheme.spacing
//https://pspdfkit.com/blog/2021/converting-an-image-to-pdf-in-kotlin/
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PdfConverterLight() {
    AppTheme {
        PdfConverterScreen(null,null)
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PdfConverterDark() {
    AppTheme {
        PdfConverterScreen(null,null)
    }
}