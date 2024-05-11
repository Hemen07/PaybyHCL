package com.hcl.hclpayby.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.hcl.hclpaybay.R
import com.hcl.hclpaybay.databinding.FragmentEmailBinding
import com.hcl.hclpayby.ui.base.BaseFragment

private const val TAG = "Pixel-EmailFragment : "

class EmailFragment : BaseFragment() {


    override fun getToolbarTitle() = "${getString(R.string.app_name)} EF"

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ViewBinding {
        return FragmentEmailBinding.inflate(inflater, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: |||||  EMAIL ||||| ")

        (binding as FragmentEmailBinding).apply {
            tv1GotoSettingsFromEmailFragment.setOnClickListener {
                Log.i(TAG, "tv1GotoSettingsFromEmailFragment : TAP TAP")
//                sharedNavigationVM.doNavigation(
//                    actionId = R.id.action_emailFragment_to_settingsFragment,
//                    bundle = Bundle().apply {
//                        this.putString("POPUPTO", "POPUPTO")
//                    }
//                )
            }
        }

        // added new menu specific to this Fragment.
//        addOptionsMenu()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG, "onDestroyView: ")
        _binding = null
//        requireActivity().removeMenuProvider(provider = provider)
    }

}