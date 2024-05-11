package com.hcl.hclpayby.data.microservices.mappers

import android.util.Log
import com.hcl.hclpayby.data.microservices.entities.responses.OtpResponse
import com.hcl.hclpayby.domain.entities.responses.ClientOtpResponse

private const val TAG = "HCL-ResponseMapper : "


/**
 * Map to client
 *
 * Take care of null
 * Assign empty values
 */
internal fun OtpResponse?.mapToClient(): ClientOtpResponse {
    Log.d(TAG, "mapToClient: ")
    return ClientOtpResponse(status = this?.status ?: "")
}

