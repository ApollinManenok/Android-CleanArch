package com.gmail.pmanenok.tasks.presentation.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.util.Log
import java.io.File

private const val CAMERA_REQUEST_CODE = 123
private const val GALERY_REQUEST_CODE = 222
private const val CAMERA_FILE_NAME = "/camera"
private const val CAMERA_FILE_EXT = ".jpg"

fun startCamera(activity: Activity) {
    var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    if (intent.resolveActivity(activity.packageManager) != null) {
        val file =
            File(activity.getExternalFilesDir(null).absolutePath + CAMERA_FILE_NAME + CAMERA_FILE_EXT)//rxpermission
        if (file.exists()) {
            file.delete()
        }
        val fileUrl = FileProvider.getUriForFile(
            activity,
            "com.gmail.pmanenok.tasks.presentation.utils.GeneralFileProvider",
            file
        )
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUrl)
        intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)
        activity.startActivityForResult(intent, CAMERA_REQUEST_CODE)
    } else {
        Log.e("camera", "No Camera App on devise")
        //No Camera App on devise
    }

}

fun checkActivityResult(context: Context, requestCode: Int, resultCode: Int, data: Intent?): File? {
    if (resultCode != Activity.RESULT_OK) {
        return null
    }
    when (requestCode) {
        CAMERA_REQUEST_CODE -> {
            val file =
                File(context.getExternalFilesDir(null).absolutePath + CAMERA_FILE_NAME + CAMERA_FILE_EXT)//rxpermission
            if (file.exists()) {
                return file
            }
        }
        else -> {
        }
    }
    return null
}

fun startGalery() {

}
