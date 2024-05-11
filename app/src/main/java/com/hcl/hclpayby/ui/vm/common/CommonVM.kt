package com.hcl.hclpayby.ui.vm.common

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.hcl.hclpayby.di.app.dispatcher.DefaultDispatcher
import com.hcl.hclpayby.di.app.dispatcher.IODispatcher
import com.hcl.hclpayby.domain.common.ClientApiResult
import com.hcl.hclpayby.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

private const val TAG = "HCL_Common_VM : "

/**
 * Common VM
 * For brevity, just getting the static data from Util.
 */
@HiltViewModel
class CommonVM @Inject constructor(
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel<ClientApiResult<*>>() {

    fun something() {

    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared: ")
    }

}