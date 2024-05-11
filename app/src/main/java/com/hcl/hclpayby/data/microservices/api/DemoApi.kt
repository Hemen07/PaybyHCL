package com.hcl.hclpayby.data.microservices.api

import com.hcl.hclpayby.data.microservices.entities.responses.OtpResponse
import retrofit2.Response
import retrofit2.http.GET


interface DemoApi {

    /**
     * Otp Validation mock
     */
    @GET("/otpValidation")
    suspend fun otpValidation(): Response<OtpResponse?>
}
