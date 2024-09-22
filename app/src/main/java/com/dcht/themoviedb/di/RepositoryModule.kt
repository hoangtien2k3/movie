package com.dcht.themoviedb.di

import com.dcht.themoviedb.data.repository.MovaRepositoryImpl
import com.dcht.themoviedb.domain.repository.MovaRepository
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