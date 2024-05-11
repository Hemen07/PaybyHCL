package com.hcl.hclpayby.ui.vm

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.hcl.hclpayby.di.app.dispatcher.DefaultDispatcher
import com.hcl.hclpayby.di.app.dispatcher.IODispatcher
import com.hcl.hclpayby.domain.common.ClientApiResult
import com.hcl.hclpayby.domain.usecases.GetOtpValidationUseCase
import com.hcl.hclpayby.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "HCL_VM : "

/**
 * VM
 */
@HiltViewModel
class VM @Inject constructor(
    private val getOtpValidationUseCase: GetOtpValidationUseCase,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel<ClientApiResult<*>>() {

    fun doOtpValidation() {
        Log.d(TAG, "doOtpValidation: ||")
        uiState.value = ClientApiResult.Loading
        viewModelScope.launch {
            when (val clientApiResult = getOtpValidationUseCase.invoke()) {
                is ClientApiResult.Loading -> {
                }

                is ClientApiResult.Success -> {
                    uiState.value = ClientApiResult.Success(data = clientApiResult.data)
                }

                is ClientApiResult.Error -> {
                    uiState.value = ClientApiResult.Error(
                        code = clientApiResult.code,
                        errorMessage = clientApiResult.errorMessage
                    )
                }

                is ClientApiResult.Exception -> {
                    uiState.value = ClientApiResult.Exception(throwable = clientApiResult.throwable)
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared: ")
    }

}