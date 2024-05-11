package com.hcl.hclpayby.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewbinding.ViewBinding
import com.hcl.hclpayby.ui.vm.navigation.SharedNavigationVM

private const val TAG = "Pixel-BaseFragment : "

/**
 * Base class for activity
 */
abstract class BaseFragment : Fragment() {

    protected var _binding: ViewBinding? = null
    protected val binding get() = _binding!!

    // shared - activityViewModels()
    protected val sharedNavigationVM: SharedNavigationVM by activityViewModels()

    abstract fun getToolbarTitle(): String

    abstract fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getBinding(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedNavigationVM.changeToolbarTitle(title = getToolbarTitle())
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}