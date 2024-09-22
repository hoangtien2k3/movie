package com.dcht.themoviedb.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dcht.themoviedb.data.model.local.Bookmark
import com.dcht.themoviedb.data.model.local.Download

@Database(
    entities = [Bookmark::class, Download::class],
    version = 1,
    exportSchema = false
)
abstract class MovaDatabase : RoomDatabase() {
    abstract fun metflixDao(): MovaDao
}