package com.tinz.mydocmanager.ui.screens.pdf;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ImageDecoder;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tinz.mydocmanager.MyDocApplicationClass;
import com.tinz.mydocmanager.utils.Constants;
import kotlinx.coroutines.Dispatchers;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.Executors;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0002J\u0014\u0010\"\u001a\u00020!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020!0$J\u000e\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\'J\u000e\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\rJ\u0014\u0010*\u001a\u00020!2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00118F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u00198F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006."}, d2 = {"Lcom/tinz/mydocmanager/ui/screens/pdf/PdfViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "<set-?>", "Landroidx/lifecycle/MutableLiveData;", "", "open", "getOpen", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/tinz/mydocmanager/ui/screens/pdf/OpenDialogState;", "openDialog", "getOpenDialog", "()Lcom/tinz/mydocmanager/ui/screens/pdf/OpenDialogState;", "setOpenDialog", "(Lcom/tinz/mydocmanager/ui/screens/pdf/OpenDialogState;)V", "openDialog$delegate", "Landroidx/compose/runtime/MutableState;", "Lcom/tinz/mydocmanager/ui/screens/pdf/PdfConverterScreenState;", "state", "getState", "()Lcom/tinz/mydocmanager/ui/screens/pdf/PdfConverterScreenState;", "setState", "(Lcom/tinz/mydocmanager/ui/screens/pdf/PdfConverterScreenState;)V", "state$delegate", "closeDialog", "", "convertPicturesToPdf", "onPdfGenerated", "Lkotlin/Function0;", "onItemRemove", "index", "", "updateOpenDialogueStatus", "isOpen", "updateSelectedImageList", "listOfImages", "", "Landroid/net/Uri;", "app_debug"})
public final class PdfViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String TAG = "MyCommentsTinz";
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState state$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState openDialog$delegate = null;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> open;
    
    public PdfViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tinz.mydocmanager.ui.screens.pdf.PdfConverterScreenState getState() {
        return null;
    }
    
    public final void setState(@org.jetbrains.annotations.NotNull
    com.tinz.mydocmanager.ui.screens.pdf.PdfConverterScreenState p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tinz.mydocmanager.ui.screens.pdf.OpenDialogState getOpenDialog() {
        return null;
    }
    
    public final void setOpenDialog(@org.jetbrains.annotations.NotNull
    com.tinz.mydocmanager.ui.screens.pdf.OpenDialogState p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getOpen() {
        return null;
    }
    
    public final void updateOpenDialogueStatus(boolean isOpen) {
    }
    
    public final void updateSelectedImageList(@org.jetbrains.annotations.NotNull
    java.util.List<? extends android.net.Uri> listOfImages) {
    }
    
    public final void onItemRemove(int index) {
    }
    
    private final void closeDialog() {
    }
    
    public final void convertPicturesToPdf(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onPdfGenerated) {
    }
}