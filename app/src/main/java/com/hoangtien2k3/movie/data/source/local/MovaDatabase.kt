package com.hoangtien2k3.movie.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hoangtien2k3.movie.data.model.local.Bookmark
import com.hoangtien2k3.movie.data.model.local.Download

@Database(
    entities = [Bookmark::class, Download::class],
    version = 1,
    exportSchema = false
)
abstract class MovaDatabase : RoomDatabase() {
    abstract fun metflixDao(): MovaDao
}