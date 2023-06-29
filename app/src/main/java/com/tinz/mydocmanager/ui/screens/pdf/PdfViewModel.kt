package com.tinz.mydocmanager.ui.screens.pdf

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.ImageDecoder
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tinz.mydocmanager.MyDocApplicationClass
import com.tinz.mydocmanager.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.util.concurrent.Executors

class PdfViewModel():ViewModel() {
     val context :Context = MyDocApplicationClass.getContext()
    val TAG ="MyCommentsTinz"
    var state by mutableStateOf(PdfConverterScreenState())
    var openDialog by mutableStateOf(OpenDialogState())

    var open = MutableLiveData<Boolean>()



        private set
    fun updateOpenDialogueStatus(isOpen:Boolean){
        openDialog = openDialog.copy(isOpen)
    }


    fun updateSelectedImageList(listOfImages: List<Uri>) {
        val updatedImageList = state.listOfSelectedImages.toMutableList()
        viewModelScope.launch {
            updatedImageList += listOfImages
            state = state.copy(
                listOfSelectedImages = updatedImageList.distinct()
            )
        }
    }

    fun onItemRemove(index: Int) {
        val updatedImageList = state.listOfSelectedImages.toMutableList()
        viewModelScope.launch {
            updatedImageList.removeAt(index)
            state = state.copy(
                listOfSelectedImages = updatedImageList.distinct()
            )
        }
    }




    private fun closeDialog() {
        open.value = false
    }

     fun convertPicturesToPdf(onPdfGenerated:()-> Unit) {


        val executorService = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        executorService.execute {
            var picturesToPdfList = state.listOfSelectedImages



            Log.d(TAG, "convertPicturesToPdf: ${picturesToPdfList.size}")
            try {
                val root = File(context.getExternalFilesDir(null), Constants.PDF_FOLDER)
                root.mkdirs()
                val timestamp = System.currentTimeMillis()
                val fileName = "PDF_$timestamp.pdf"
                val file = File(root, fileName)
                Log.d(TAG, ""+file.absolutePath)


                val fileOutputStream = FileOutputStream(file)
                val pdfDocument = PdfDocument()
                var cnt = 0
                for(i in picturesToPdfList.indices) {
                    val pictureToPdfUri = picturesToPdfList[i]
                    try{
                        Log.d(TAG, "convertPictures : $i")

                        var bitmap : Bitmap
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                            bitmap = ImageDecoder.decodeBitmap(ImageDecoder.createSource(context.contentResolver, pictureToPdfUri))
                        }
                        else {
                            bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, pictureToPdfUri)
                        }
                        bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, false)
                        cnt += 1
                        val pageInfo = PdfDocument.PageInfo.Builder(bitmap.width, bitmap.height,cnt+1).create()
                        val page = pdfDocument.startPage(pageInfo)
                        val paint = Paint()
                        val canvas = page.canvas
                        canvas.drawPaint(paint)
                        canvas.drawBitmap(bitmap,0f,0f, null)
                        paint.color = Color.WHITE
                        pdfDocument.finishPage(page)
                        bitmap.recycle()
                    }
                    catch (e:Exception) {

                        Log.e(TAG,e.toString())
                    }
                }
                pdfDocument.writeTo(fileOutputStream)
                pdfDocument.close()
            }
            catch(e : Exception) {
                Log.e(TAG,e.toString())

            }
            handler.post {
                Log.e(TAG,"PDF Generated")
                onPdfGenerated()
            }

        }
    }
}