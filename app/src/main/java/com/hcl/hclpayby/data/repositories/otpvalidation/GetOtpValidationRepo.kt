package com.hcl.hclpayby.data.repositories.otpvalidation

import com.hcl.hclpayby.domain.common.ClientApiResult
import com.hcl.hclpayby.domain.entities.responses.ClientOtpResponse

interface GetOtpValidationRepo {
    suspend fun getOtpValidation(): ClientApiResult<ClientOtpResponse>
}