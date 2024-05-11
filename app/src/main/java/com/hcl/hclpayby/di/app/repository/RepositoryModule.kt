package com.example.g5r.di.app.repository

import com.hcl.hclpayby.data.microservices.api.DemoApi
import com.hcl.hclpayby.data.microservices.service.GetOtpValidationService
import com.hcl.hclpayby.data.repositories.otpvalidation.GetOtpValidationRepo
import com.hcl.hclpayby.data.repositories.otpvalidation.GetOtpValidationRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val TAG = "HCL-RepositoryModule : "


/**
 * Repository module
 * ------------------
 * All repositories related here
 * Obviously connected to [UseCaseModule]
 *
 *
 */
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    /**
     * Provides Get trending repository
     * Using API [DemoApi]
     * @param getOtpValidationService : [GetOtpValidationService] instance
     * @return
     */
    @Provides
    @Singleton
    fun provideGetOtpValidationRepository(
        getOtpValidationService: GetOtpValidationService,
    ): GetOtpValidationRepo {
        return GetOtpValidationRepoImpl(
            getOtpValidationService = getOtpValidationService,
        )
    }


}