package com.hcl.hclpayby.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.hcl.hclpaybay.R
import com.hcl.hclpaybay.databinding.FragmentSettingsBinding
import com.hcl.hclpayby.ui.base.BaseFragment

private const val TAG = "Pixel-SettingsFragment : "

class SettingsFragment : BaseFragment() {

    override fun getToolbarTitle() = "${getString(R.string.app_name)} SF"

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ViewBinding {
        return FragmentSettingsBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: |||||  SETTINGS ||||| ")

        (binding as FragmentSettingsBinding).apply {
            tv1GotoAboutFromSettingsFragment.setOnClickListener {
                Log.i(TAG, "tv1GotoAboutFromSettingsFragment : TAP TAP")
//                sharedNavigationVM.doNavigation(actionId = R.id.action_settingsFragment_to_aboutFragment)
            }
        }
    }
}