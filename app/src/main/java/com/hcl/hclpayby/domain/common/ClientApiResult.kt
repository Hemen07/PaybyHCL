package com.hcl.hclpayby.domain.common

/**
 * Api result state
 * THE DOMAIN
 *
 */
sealed class ClientApiResult<out R> {
    data object Loading : ClientApiResult<Nothing>()
    data class Success<out T>(val data: T) : ClientApiResult<T>()
    data class Error(
        val code: Int = 500,
        val errorMessage: String
    ) : ClientApiResult<Nothing>()

    data class Exception(val throwable: Throwable) : ClientApiResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data = $data]"
            is Error -> "Error[code = $code and message = $errorMessage]"
            is Exception -> "Exception[throwable = $throwable]"
            is Loading -> "Loading"
        }
    }
}
