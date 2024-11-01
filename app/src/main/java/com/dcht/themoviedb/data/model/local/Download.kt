package com.dcht.themoviedb.data.model.local

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dcht.themoviedb.common.enums.MediaTypeEnum
import com.dcht.themoviedb.common.getRandomDownloadSize
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "downloads")
data class Download(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    var imageFilePath: String,
    val backdrop: String,
    val runtime: Int,
    val downloadSize: Double = getRandomDownloadSize(),
    val type: MediaTypeEnum,
    val addDate: String = Calendar.getInstance().time.toString()
) : Parcelable
