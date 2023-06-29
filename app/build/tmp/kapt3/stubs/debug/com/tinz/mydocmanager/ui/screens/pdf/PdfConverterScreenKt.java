package com.tinz.mydocmanager.ui.screens.pdf;

import android.Manifest;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.tooling.preview.Preview;
import androidx.navigation.NavController;
import com.tinz.mydocmanager.R;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells;
import androidx.compose.material.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.ContentScale;
import androidx.constraintlayout.compose.Dimension;
import com.google.accompanist.permissions.ExperimentalPermissionsApi;
import com.tinz.mydocmanager.MyDocApplicationClass;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\b\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u001c\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007\u00a8\u0006\b"}, d2 = {"PdfConverterDark", "", "PdfConverterLight", "PdfConverterScreen", "viewModel", "Lcom/tinz/mydocmanager/ui/screens/pdf/PdfViewModel;", "navController", "Landroidx/navigation/NavController;", "app_debug"})
public final class PdfConverterScreenKt {
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {com.google.accompanist.permissions.ExperimentalPermissionsApi.class, androidx.compose.foundation.ExperimentalFoundationApi.class})
    public static final void PdfConverterScreen(@org.jetbrains.annotations.NotNull
    com.tinz.mydocmanager.ui.screens.pdf.PdfViewModel viewModel, @org.jetbrains.annotations.Nullable
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO)
    public static final void PdfConverterLight() {
    }
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
    public static final void PdfConverterDark() {
    }
}