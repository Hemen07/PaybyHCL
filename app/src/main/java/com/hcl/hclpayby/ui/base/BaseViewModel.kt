package com.hcl.hclpayby.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Base view model
 */
open class BaseViewModel<T> : ViewModel() {

    /**
     * Ui state MutableLiveData
     */
    protected val uiState: MutableLiveData<T> = MutableLiveData()

    /**
     * Use this from Activity/Fragment where you want to observe
     * Get the Ui state as LD
     *
     * @return LiveData
     */
    fun uiState(): LiveData<T> = uiState
}