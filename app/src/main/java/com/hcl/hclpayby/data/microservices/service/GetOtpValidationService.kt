package com.hcl.hclpayby.data.microservices.service

import com.hcl.hclpayby.data.microservices.api.DemoApi
import com.hcl.hclpayby.data.microservices.common.BaseApi
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class GetOtpValidationService @Inject constructor(
    private val demoApi: DemoApi
) : BaseApi() {

    @Throws(Exception::class)
    suspend fun get() = handleApi {
        demoApi.otpValidation()
    }

}