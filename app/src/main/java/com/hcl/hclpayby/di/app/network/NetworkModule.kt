package com.hcl.hclpayby.di.app.network

import com.hcl.hclpayby.data.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


private const val TAG = "HCL-NetworkModule : "

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    /**
     * Provide ok http client
     *
     * @return
     */
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            // timeout any !
            .build()
    }

    /**
     * Provide baseurl
     */
    @Provides
    fun provideBaseurl() = BASE_URL

    /**
     * Provide retrofit
     *
     * @param baseUrl
     * @param client
     * @return
     */
    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}