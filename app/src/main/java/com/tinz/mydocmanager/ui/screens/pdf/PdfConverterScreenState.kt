package com.tinz.mydocmanager.ui.screens.pdf

import android.net.Uri

data class PdfConverterScreenState(val listOfSelectedImages :List<Uri> = emptyList())
data class OpenDialogState(val openDialogue:Boolean =false)
