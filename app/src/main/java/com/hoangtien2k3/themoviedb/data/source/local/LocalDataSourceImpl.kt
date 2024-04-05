package com.hoangtien2k3.themoviedb.data.source.local

import com.hoangtien2k3.themoviedb.data.model.local.Bookmark
import com.hoangtien2k3.themoviedb.data.model.local.Download
import com.hoangtien2k3.themoviedb.domain.source.DataSource
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val movaDao: MovaDao) :
    DataSource.Local {
    override suspend fun addBookmark(bookmark: Bookmark) = movaDao.addBookmark(bookmark)

    override suspend fun removeBookmark(id: Int) = movaDao.deleteBookmark(id)

    override suspend fun isBookmarked(id: Int): Boolean = movaDao.isBookmarked(id)

    override suspend fun getBookmarks(): List<Bookmark> = movaDao.getBookmarks()
    override suspend fun addDownload(download: Download) = movaDao.addDownload(download)

    override suspend fun removeDownloaded(id: Int) = movaDao.deleteDownload(id)

    override suspend fun isDownloaded(id: Int): Boolean = movaDao.isDownloaded(id)

    override suspend fun getDownloads(): List<Download> = movaDao.getDownloads()
}