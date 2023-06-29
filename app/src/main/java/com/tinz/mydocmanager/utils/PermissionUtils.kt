package com.tinz.mydocmanager.utils

import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.core.content.ContextCompat

fun checkReadAndWritePermissionRequest(context: Context,
                                       permissions: Array<String>,
                                       launcher: ManagedActivityResultLauncher<Array<String>,
                                               Map<String, Boolean>>,onPermissionGranted: ()-> Unit
) {
    if (
        permissions.all {
            ContextCompat.checkSelfPermission(
                context,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    ) {
        onPermissionGranted()
        // Use location because permissions are already granted
    } else {
        // Request permissions
        launcher.launch(permissions)
    }
}