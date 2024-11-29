package com.core.util.compose.file

import android.app.Application
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.ParcelFileDescriptor
import android.util.Log
import com.core.util.compose.ext.FileExt
import com.core.util.compose.ext.FileExt.toUri
import java.io.File
import javax.inject.Inject

data class Music(
    val id: String,
    val title: String,
    val album: String,
    val artist: String,
    val duration: Int,
    val path: String,
    val pictureUri: String?,
)

class ContentResolver @Inject constructor(private val context: Application) {
    private val contentResolver = context.contentResolver
    private val externalCashDir: File? = context.externalCacheDir

    fun getMetadataFromFile(uri: Uri): Music? {
        val retriever = MediaMetadataRetriever()
        var parcelFileDescriptor: ParcelFileDescriptor? = null

        with(retriever) {
            return try {
                parcelFileDescriptor = contentResolver.openFileDescriptor(uri, "r")
                parcelFileDescriptor?.fileDescriptor?.let { fileDescriptor ->
                    setDataSource(fileDescriptor)

                    val title =
                        extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE) ?: UNKNOWN_VALUE
                    val album =
                        extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM) ?: UNKNOWN_VALUE
                    val artist =
                        extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST) ?: UNKNOWN_VALUE
                    val duration =
                        extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)?.toIntOrNull()
                            ?: 0
                    val pictureUri = embeddedPicture?.run {
                        val file =
                            FileExt.createExternalCashDir(
                                externalCashDir,
                                this,
                                this.size.toString()
                            )
                        file?.toUri(context)
                    }

                    val music = Music(
                        id = uri.toString(),
                        title = title,
                        album = album,
                        artist = artist,
                        duration = duration,
                        path = uri.toString(),
                        pictureUri = pictureUri?.toString(),
                    )

                    return if (music.isValidatedDuration()) music else null
                }
            } catch (e: Exception) {
                Log.e("TEST1", "Failed to retrieve metadata: ${e.message}")
                null
            } finally {
                release()
                parcelFileDescriptor?.close()
            }
        }
    }

    private companion object {
        const val UNKNOWN_VALUE = "UNKNOWN"
    }

    private fun Music.isValidatedDuration() = duration != 0
}