package com.hcl.hclpayby.data.microservices.mappers

import android.util.Log
import com.hcl.hclpayby.data.microservices.common.ApiResult
import com.hcl.hclpayby.domain.common.ClientApiResult

/**
 * ApiResultMapper - Data to Domain mapper
 */
private const val TAG = "HCL-ApiResultMapper : "


/**
 * Use this when Success is Unit type
 */
internal fun <T> ApiResult<T>.apiMapToClient(): ClientApiResult<T> {
    return when (this) {
        is ApiResult.Success ->
            if (this.data != null) {
                ClientApiResult.Success(this.data)
            } else {
                ClientApiResult.Error(
                    code = this.code,
                    errorMessage = this.errorMessage ?: "Unknown Error"
                )
            }

        is ApiResult.Error ->
            ClientApiResult.Error(
                code = this.code,
                errorMessage = this.errorMessage ?: "Unknown Error"
            )

        is ApiResult.Exception ->
            ClientApiResult.Exception(
                throwable = t ?: Exception("Unknown Exception")
            )
    }
}

/**
 * Result Mapper for conversion from [ApiResult] to [ClientApiResult]
 */
internal fun <T, R> ApiResult<T>.apiMapToClient(mapper: T.() -> R): ClientApiResult<R> {
    Log.d(TAG, "apiMapToClient: ")
    return when (this) {
        is ApiResult.Success -> {
            if (this.data != null) {
                Log.d(TAG, "apiMapToClient: SUCCESS : success = ${this.data}")
                return ClientApiResult.Success(data = this.data.mapper())
            } else {
                Log.d(TAG, "apiMapToClient: SUCCESS : error")
                return ClientApiResult.Error(
                    code = code,
                    errorMessage = errorMessage ?: "Unknown Error"
                )
            }
        }

        is ApiResult.Error -> {
            Log.d(TAG, "apiMapToClient: ERROR")
            ClientApiResult.Error(
                code = this.code,
                errorMessage = this.errorMessage ?: "Unknown Error"
            )
        }

        is ApiResult.Exception -> {
            Log.d(TAG, "apiMapToClient: EXCEPTION")
            ClientApiResult.Exception(
                throwable = t ?: Exception("Unknown Exception")
            )
        }
    }
}