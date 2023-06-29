package com.tinz.mydocmanager.ui.screens.pdf

import android.Manifest
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.tinz.mydocmanager.R
import com.tinz.mydocmanager.ui.screens.common_widgets.AppbarCommon
import com.tinz.mydocmanager.ui.screens.common_widgets.UploadViewCommon
import com.tinz.mydocmanager.ui.theme.AppTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.permissions.rememberPermissionState
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.Dimension
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.tinz.mydocmanager.MyDocApplicationClass
import com.tinz.mydocmanager.ui.screens.common_widgets.AppThemedButton
import com.tinz.mydocmanager.ui.screens.common_widgets.DialogBoxLoading
import com.tinz.mydocmanager.ui.screens.common_widgets.ImagePreviewItem
import com.tinz.mydocmanager.ui.theme.spacing
import com.tinz.mydocmanager.utils.checkReadAndWritePermissionRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PdfConverterScreen : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                PdfConverterScreen(viewModel = PdfViewModel(),null)
            }
        }
        MyDocApplicationClass.setContext(this)

    }
}
@OptIn(ExperimentalPermissionsApi::class, ExperimentalFoundationApi::class)
@Composable
fun PdfConverterScreen(viewModel: PdfViewModel = viewModel(), navController: NavController?) {
    val context = LocalContext.current.applicationContext
    val state = viewModel.state
    val openDialogState = viewModel.openDialog
    val openDialog = remember { mutableStateOf(false)  }
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val coroutineScope = rememberCoroutineScope()
    val permissions = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    val launcherMultiplePermissions = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissionsMap ->
        val areGranted = permissionsMap.values.reduce { acc, next -> acc && next }
        if (areGranted) {
            // Use location
        } else {
            // Show dialog
        }
    }

    val permissionState = rememberPermissionState(Manifest.permission.READ_EXTERNAL_STORAGE)

    val galleryLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.GetMultipleContents()
        ) {
            viewModel.updateSelectedImageList(listOfImages = it)
        }

    SideEffect {
        permissionState.launchPermissionRequest()
    }
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (refHeader,refLazyGrid,refAddMoreButton) = createRefs()
        val spacing = MaterialTheme.spacing

        Box(
            modifier = Modifier
                .constrainAs(refHeader) {
                    top.linkTo(parent.top, spacing.zeroDp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                .wrapContentSize()
        ) {
            AppbarCommon()

        }


        if (state.listOfSelectedImages?.isNotEmpty() == true) {
            Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center,
                modifier = Modifier.constrainAs(refAddMoreButton) {
                    top.linkTo(refHeader.bottom, spacing.small)
                    width = Dimension.fillToConstraints
                }
            ) {
                Row(horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        AppThemedButton({
                            checkReadAndWritePermissionRequest(
                                context,
                                permissions,
                                launcherMultiplePermissions
                            ) {
                                galleryLauncher.launch("image/*")
                            }

                        },10.dp, Color.White, stringResource(id = R.string.select_more_imgs))

                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        AppThemedButton({
                            viewModel.updateOpenDialogueStatus(true)
                            coroutineScope.launch {
                                withContext(Dispatchers.IO) {
                                    try {
                                        viewModel.convertPicturesToPdf({
                                            openDialog.value = false
                                            viewModel.updateOpenDialogueStatus(false)

                                        })
                                    } catch (e: Exception) {
                                       Log.e("AppComent",e.toString())
                                    } finally {
                                        openDialog.value = false
                                        viewModel.updateOpenDialogueStatus(false)

                                    }
                                }
                            }

                            openDialog.value = true
                        },10.dp, Color.White, stringResource(id = R.string.convertToPdf))

                    }

                }

                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 128.dp),
                    verticalArrangement = Arrangement.spacedBy(3.dp),
                    horizontalArrangement = Arrangement.spacedBy(3.dp),
                    modifier = Modifier.padding(bottom = 150.dp, start = 10.dp, end = 10.dp)
                ) {
                    items(state.listOfSelectedImages.size, key = { it }) {
                        ImagePreviewItem(uri = state.listOfSelectedImages[it],
                            height = screenHeight * 0.5f,
                            width = screenWidth * 0.6f,
                            onClick = { viewModel.onItemRemove(it) }
                        )
                    }
                }

            }
            Spacer(modifier = Modifier.height(400.dp))

            if (openDialogState.openDialogue)
            {
                DialogBoxLoading(stringResource(id = R.string.convertToPdf))

            }

        }
        else{
            UploadViewCommon(stringResource(id = R.string.test_pdf_upload)){
                if (permissionState.status.isGranted)
                {
                    galleryLauncher.launch("image/*")

                }else{
                    val intent = Intent(
                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.fromParts("package", context.packageName, null))
                    startActivity(context,intent,null)
                }


            }
        }




    }


}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PdfConverterLight() {
    AppTheme {
        PdfConverterScreen(viewModel = PdfViewModel(),null)
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PdfConverterDark() {
    AppTheme {
        PdfConverterScreen(viewModel = PdfViewModel(),null)
    }
}
