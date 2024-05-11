package com.hcl.hclpayby.data.repositories.otpvalidation

import com.hcl.hclpayby.data.microservices.mappers.apiMapToClient
import com.hcl.hclpayby.data.microservices.mappers.mapToClient
import com.hcl.hclpayby.data.microservices.service.GetOtpValidationService
import com.hcl.hclpayby.domain.common.ClientApiResult
import com.hcl.hclpayby.domain.entities.responses.ClientOtpResponse
import javax.inject.Inject

private const val TAG = "HCL-GetTrendingRepoImpl : "

class GetOtpValidationRepoImpl @Inject constructor(
    private val getOtpValidationService: GetOtpValidationService,
) : GetOtpValidationRepo {

    override suspend fun getOtpValidation(): ClientApiResult<ClientOtpResponse> {
        return getOtpValidationService
            .get()
            .apiMapToClient {
                this.mapToClient()
            }
    }

}