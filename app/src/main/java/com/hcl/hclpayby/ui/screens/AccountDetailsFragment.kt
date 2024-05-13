package com.hcl.hclpayby.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hcl.hclpaybay.R
import com.hcl.hclpaybay.databinding.FragmentAccountDetailsBinding
import com.hcl.hclpayby.ui.screens.Adapter.AdapterTransaction

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AccountDetailsFragment : Fragment() {

    private var _binding: FragmentAccountDetailsBinding? = null
    private var mIsAmountVisible: Boolean = false
    private lateinit var adapterTransaction: AdapterTransaction

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAccountDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvName.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_accountDetails)
        }

        val dataset = arrayOf("January", "February", "March", "April", "May")
        adapterTransaction = AdapterTransaction(emptyArray())
        binding.rvAllTransactions.layoutManager  = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        _binding?.rvAllTransactions?.adapter = adapterTransaction

        binding.visibiltyIcon.setOnClickListener{
            if (mIsAmountVisible){
                binding.tvAmount.text = "*****"
                binding.visibiltyIcon.setBackgroundResource(R.drawable.eye_closed)
                mIsAmountVisible = false
            } else {
                binding.tvAmount.text = "30000.00"
                binding.visibiltyIcon.setBackgroundResource(R.drawable.eye_open)
                mIsAmountVisible = true
            }

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}