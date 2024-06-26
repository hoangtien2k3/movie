package com.hoangtien2k3.themoviedb.di

import com.hoangtien2k3.themoviedb.data.repository.MovaRepositoryImpl
import com.hoangtien2k3.themoviedb.domain.repository.MovaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideMovieRepository(metflixRepositoryImpl: MovaRepositoryImpl): MovaRepository
}