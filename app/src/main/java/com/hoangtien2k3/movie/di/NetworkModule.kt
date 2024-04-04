package com.hoangtien2k3.movie.di

import com.google.gson.Gson
import com.hoangtien2k3.movie.common.Constants.API_KEY
import com.hoangtien2k3.movie.common.Constants.BASE_URL
import com.hoangtien2k3.movie.common.interceptor.ApiKeyInterceptor
import com.hoangtien2k3.movie.common.interceptor.LanguageInterceptor
import com.hoangtien2k3.movie.data.source.remote.MovaService
import com.hoangtien2k3.movie.domain.source.DataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    @Named("apiKey")
    fun provideApiKey(): String = API_KEY

    @Provides
    @Singleton
    @IntoSet
    fun provideApiKeyInterceptor(@Named("apiKey") apiKey: String): Interceptor {
        return ApiKeyInterceptor(apiKey)
    }

    @Provides
    @Singleton
    @IntoSet
    fun provideLanguageInterceptor(preferenceDataSource: DataSource.Preference): Interceptor {
        return LanguageInterceptor(preferenceDataSource)
    }

    @Singleton
    @Provides
    fun provideHttpClient(interceptors: Set<@JvmSuppressWildcards Interceptor>): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .apply {
                interceptors().addAll(interceptors)
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Provides
    @Singleton
    @Named("baseUrl")
    fun provideBaseUrl(): String = BASE_URL

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
        @Named("baseUrl") baseUrl: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .build()

    @Provides
    @Singleton
    fun provideMovaService(retrofit: Retrofit): MovaService =
        retrofit.create(MovaService::class.java)

}