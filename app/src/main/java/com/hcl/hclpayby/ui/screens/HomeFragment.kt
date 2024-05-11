package com.hcl.hclpayby.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding
import com.hcl.hclpaybay.R
import com.hcl.hclpaybay.databinding.FragmentHomeBinding
import com.hcl.hclpayby.ui.base.BaseFragment

private const val TAG = "Pixel-HomeFragment : "

/**
 * Home fragment  |||||||  MAIN FRAGMENT
 *
 * @constructor Create empty Home fragment
 */
class HomeFragment : BaseFragment() {

    override fun getToolbarTitle() = getString(R.string.app_name)

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ViewBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: |||||  HOME - - ||||| ")
        //
        (binding as FragmentHomeBinding).apply {

            val purple = ContextCompat.getColor(requireContext(), R.color.purple_200)
            val teal = ContextCompat.getColor(requireContext(), R.color.teal_200)

            tvSettingHomeFragment.text = "SETTINGS"

            tvAboutHomeFragment.text = "ABOUT"

            tvEmailHomeFragment.text = "EMAIL"


            tvSettingHomeFragment.setOnClickListener {
                Log.i(TAG, "tvSettingHomeFragment : TAP TAP")
                // 1st control goes to MA
                // and from there it happens
                // shared vm
                sharedNavigationVM.doNavigation(actionId = R.id.action_homeFragment_to_settingsFragment)
            }

            tvAboutHomeFragment.setOnClickListener {
                Log.i(TAG, "tvAboutHomeFragment : TAP TAP")
                sharedNavigationVM.doNavigation(
                    actionId = R.id.action_homeFragment_to_aboutFragment,
                    bundle = Bundle().apply {
                        this.putString("Hola", "Home I need | Lord | Universe")
                    }
                )
            }

            tvEmailHomeFragment.setOnClickListener {
                Log.i(TAG, "tvEmailHomeFragment : TAP TAP")
                sharedNavigationVM.doNavigation(actionId = R.id.action_homeFragment_to_emailFragment)
            }
        }
    }
}