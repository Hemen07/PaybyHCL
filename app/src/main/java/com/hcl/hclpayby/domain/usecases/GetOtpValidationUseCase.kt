package com.hcl.hclpayby.domain.usecases

import com.hcl.hclpayby.data.repositories.otpvalidation.GetOtpValidationRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetOtpValidationUseCase @Inject constructor(
    private val getOtpValidationRepo: GetOtpValidationRepo
) {
    suspend fun invoke() = getOtpValidationRepo.getOtpValidation()
}