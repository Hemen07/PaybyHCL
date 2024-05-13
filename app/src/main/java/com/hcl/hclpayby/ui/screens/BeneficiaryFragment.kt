package com.hcl.hclpayby.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.hcl.hclpaybay.R
import com.hcl.hclpaybay.databinding.FragmentBeneficiaryBinding
import com.hcl.hclpayby.di.adapter.AdapterBeneficiaries
import com.hcl.hclpayby.ui.base.BaseFragment

private const val TAG = "Pixel-EmailFragment : "

class BeneficiaryFragment : BaseFragment() {


    override fun getToolbarTitle() = "${getString(R.string.app_name)} EF"

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ViewBinding {
        return FragmentBeneficiaryBinding.inflate(inflater, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: |||||  EMAIL ||||| ")

        (binding as FragmentBeneficiaryBinding).apply {

            val adapterBeneficiaries = AdapterBeneficiaries(emptyArray())
            rvBeneficiary.adapter = adapterBeneficiaries
            val layoutManager  = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rvBeneficiary.layoutManager = layoutManager
            rvBeneficiary.adapter = adapterBeneficiaries
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