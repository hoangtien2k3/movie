package com.dcht.themoviedb.di

import android.content.Context
import android.content.SharedPreferences
import com.dcht.themoviedb.common.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(
            Constants.Preferences.SHARED_PREF_NAME,
            Context.MODE_PRIVATE
        )
    }

}
