package com.hcl.hclpayby.data.microservices.common

import android.util.Log
import retrofit2.HttpException
import retrofit2.Response

private const val TAG = "HCL-BaseApi : "

/**
 * Base Api
 *
 * + common implementation for api calls
 * + maps network result to [ApiResult]
 */
open class BaseApi() {

    /**
     * HandleApi/ safeCallApi
     * -----------------------
     * @param execute : Lambda of your request call.

     */
    suspend fun <T> handleApi(execute: suspend () -> Response<T>): ApiResult<T> {
        Log.d(TAG, "handleApi")
        // network lambda here
        return try {
            val response = execute()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Log.d(TAG, "handleApi: YES || SUCCESS")
                return ApiResult.Success(data = body, code = response.code(), errorMessage = null)
            } else {
                Log.e(TAG, "handleApi: YES || FAIL ")
                ApiResult.Error(code = response.code(), errorMessage = response.message())
            }
        } catch (e: HttpException) {
            Log.e(TAG, "handleApi: catch || HTTP")
            ApiResult.Error(code = e.code(), errorMessage = e.message)
        } catch (throwable: Throwable) {
            Log.e(TAG, "handleApi: catch || THROWABLE")
            return ApiResult.Exception(t = throwable)
        }
    }
}