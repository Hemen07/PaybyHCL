package com.hcl.hclpayby.data.microservices.common

/**
 * API Result State
 */
sealed class ApiResult<out R> {
    data class Success<out T> internal constructor(
        val data: T? = null,
        val code: Int,
        val errorMessage: String? = null
    ) : ApiResult<T>()

    data class Error internal constructor(
        val code: Int,
        val errorMessage: String? = null
    ) : ApiResult<Nothing>()

    data class Exception internal constructor(val t: Throwable? = null) : ApiResult<Nothing>()

}

