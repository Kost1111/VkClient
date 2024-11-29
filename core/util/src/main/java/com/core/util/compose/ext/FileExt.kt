package com.core.util.compose.ext

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.core.content.FileProvider
import java.io.File

object FileExt {

    private const val FILE_PROVIDER_NAME = "com.vkclient.fileprovider"

    fun File.toUri(context: Context): Uri? = FileProvider.getUriForFile(context, FILE_PROVIDER_NAME, this)

    fun createExternalCashDir(fileDir: File?, bytes: ByteArray, fileName: String): File? {
        return if (fileDir != null) {
            createFileDir(fileDir, fileName, bytes)
        } else {
            Log.e("TEST1", "FileDir is null!")
            null
        }
    }

    private fun createFileDir(fileDir: File, fileName: String, bytes: ByteArray) =
        File(fileDir, fileName).apply {
            if (exists()) delete()
            outputStream().use { stream ->
                stream.write(bytes)
                stream.flush()
                stream.close()
            }
        }
}