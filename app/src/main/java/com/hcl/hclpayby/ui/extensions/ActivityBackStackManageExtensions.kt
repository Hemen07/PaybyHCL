package com.hcl.hclpayby.ui.extensions

import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController

private const val TAG = "Pixel-ActivityBackStackManageExtensions : "

/**
 *
 * Intended target only for Activity [AppCompatActivity]
 *
 * EXIT on liable == "fragment_home"
 *
 */


/**
 * On back press management
 *
 * EXIT on liable == "fragment_home"
 *
 * @param tag
 * @param navController
 */
fun AppCompatActivity.onBackPressManagement(
    tag: String = TAG,
    navController: NavController,
) {
    val activity = this
    val onBackPressedCallback = object : OnBackPressedCallback(enabled = true) {
        override fun handleOnBackPressed() {
            commonBackLogic(tag = tag, activity = activity, navController = navController)
        }
    }
    onBackPressedDispatcher.addCallback(this, onBackPressedCallback = onBackPressedCallback)
}

/**
 * Common back logic
 *
 * EXIT on liable == "fragment_home"
 *
 *
 * + This is for toolbar back to manage !!
 *
 * @param tag
 * @param activity
 * @param navController
 */
fun commonBackLogic(tag: String = TAG, activity: AppCompatActivity, navController: NavController) {
    Log.i(tag, "BACK-PRESS: ||| TAP ||| ")
    if (navController.currentDestination?.label != null
        &&
        navController.currentDestination?.label == "HomeFragment"
    ) {
        Log.i(tag, "BACK-PRESS: >|<  E X I T ... ")
        activity.finishAndRemoveTask()
    } else {
        Log.i(tag, "BACK-PRESS: P O P ... = ${navController.currentDestination?.label}")
        navController.popBackStack()
    }
}