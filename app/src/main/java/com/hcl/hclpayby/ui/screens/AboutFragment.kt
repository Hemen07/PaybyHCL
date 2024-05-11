package com.hcl.hclpayby.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.hcl.hclpaybay.R
import com.hcl.hclpaybay.databinding.FragmentAboutBinding
import com.hcl.hclpayby.ui.base.BaseFragment

private const val TAG = "Pixel-AboutFragment : "

class AboutFragment : BaseFragment() {

    override fun getToolbarTitle() = "${getString(R.string.app_name)} AF"

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ViewBinding {
        return FragmentAboutBinding.inflate(inflater, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: |||||  ABOUT ||||| ")

        val args = arguments?.getString("Hola")
        Log.v(TAG, "onViewCreated: RECEIVED BUNDLE = $args")

        (binding as FragmentAboutBinding).apply {
            tv1GotoEmailFromAboutFragment.setOnClickListener {
                Log.i(TAG, "tv1GotoEmailFromAboutFragment : TAP TAP")
//                sharedNavigationVM.doNavigation(actionId = R.id.action_aboutFragment_to_emailFragment)
            }
        }
    }

}