package com.hcl.hclpayby.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.hcl.hclpaybay.R
import com.hcl.hclpaybay.databinding.FragmentAccountDetailsBinding
import com.hcl.hclpayby.ui.base.BaseFragment

private const val TAG = "Pixel-SettingsFragment : "

class FundTransferFragment : BaseFragment() {

    override fun getToolbarTitle() = "${getString(R.string.app_name)} SF"

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ViewBinding {
        return FragmentAccountDetailsBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: |||||  SETTINGS ||||| ")

        (binding as FragmentAccountDetailsBinding).apply {

        }
    }
}