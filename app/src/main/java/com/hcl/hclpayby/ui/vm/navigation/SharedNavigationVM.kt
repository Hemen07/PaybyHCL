package com.hcl.hclpayby.ui.vm.navigation

import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "Pixel-SharedNavigationVM : "

/**
 * by viewModels - activity
 * by activityViewModels - in shared fragments -
 *
 *
 * THIS IS FOR COMMUNICATION
 * Let's not use BaseViewModel as that requires 1 at a time DataType for UI state
 * that one only for logic
 */
@HiltViewModel
class SharedNavigationVM @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    // UI Related

    // use this only for navigation, for screens if they bundle and popUpTo logic instead of adding to backstack
    private val uiStateNavigation: MutableLiveData<HashMap<Int, Bundle>> = MutableLiveData()

    // use this only for navigation, for title
    private val uiStateToolbar: MutableLiveData<String> = MutableLiveData()
    fun uiStateNavigation(): LiveData<HashMap<Int, Bundle>> = uiStateNavigation
    fun uiStateToolbar(): LiveData<String> = uiStateToolbar

    init {
        Log.i(TAG, "init : hash = ${hashCode()}: ")
    }

    /**
     * Do navigation
     *
     * HashMap<Int, Bundle> with size 1
     * 1st is actionId
     * and 2nd is Bundle, default is empty Bundle
     *
     * @param actionId
     * @param bundle
     */
    fun doNavigation(@IdRes actionId: Int, bundle: Bundle = Bundle()) {
        Log.d(TAG, "doNavigation:")
        viewModelScope.launch {
            uiStateNavigation.value = HashMap<Int, Bundle>(1).apply {
                this[actionId] = bundle
            }
        }
    }

    fun changeToolbarTitle(title: String) {
        Log.d(TAG, "changeToolbarTitle:")
        viewModelScope.launch {
            uiStateToolbar.value = title
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared: ")
    }

}