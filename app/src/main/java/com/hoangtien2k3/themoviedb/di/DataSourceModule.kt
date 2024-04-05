package com.hoangtien2k3.themoviedb.di

import com.hoangtien2k3.themoviedb.data.source.local.LocalDataSourceImpl
import com.hoangtien2k3.themoviedb.data.source.preference.PreferenceDataSourceImpl
import com.hoangtien2k3.themoviedb.data.source.remote.RemoteDataSourceImpl
import com.hoangtien2k3.themoviedb.domain.source.DataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun provideRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): DataSource.Remote

    @Binds
    abstract fun provideLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): DataSource.Local

    @Binds
    abstract fun providePreferenceDataSource(preferenceDataSourceImpl: PreferenceDataSourceImpl): DataSource.Preference
}