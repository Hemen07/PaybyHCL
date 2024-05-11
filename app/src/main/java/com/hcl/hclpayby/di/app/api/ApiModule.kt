package com.hcl.hclpayby.di.app.api

import com.hcl.hclpayby.data.microservices.api.DemoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

private const val TAG = "HCL-RepositoryModule : "


/**
 * ApiModule module
 * ------------------
 */
@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    /**
     * Provides Get trending repository API [DemoApi]
     * @param retrofit : [Retrofit] instance
     * @return [DemoApi] instance
     */
    @Provides
    @Singleton
    fun provideOtpValidationRepoApi(retrofit: Retrofit): DemoApi {
        return retrofit.create(DemoApi::class.java)
    }
}