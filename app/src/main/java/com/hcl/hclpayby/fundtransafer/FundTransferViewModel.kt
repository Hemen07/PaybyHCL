package com.hcl.hclpayby.fundtransafer

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hcl.hclpaybay.R
import com.hcl.hclpayby.model.Customer
import com.hcl.hclpayby.model.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FundTransferViewModel : ViewModel() {

    private var _customers =
        MutableStateFlow<Result<List<Customer>>>(Result.Initial())
    val customer = _customers.asStateFlow()

    var loggedCustomersBalance: Double = 0.0


    private var getCustomersJob: Job? = null

    fun getCustomers(context: Context) {
        getCustomersJob?.cancel()
        getCustomersJob = viewModelScope.launch(Dispatchers.IO) {
            _customers.update { Result.Loading() }
            val data = Repository.getCustomers()
            loggedCustomersBalance = Repository.getLoggedInCustomerBalance()
            if (data.isNullOrEmpty()) {
                _customers.update {
                    Result.Error(
                        message = context.getString(R.string.no_beneficiary_found)
                    )
                }
            } else {
                _customers.update { Result.Success(data) }
            }
        }
    }

    fun transfer(beneficiary: Customer, amount: String, remarks: String, context: Context) {
        getCustomersJob?.cancel()
        getCustomersJob = viewModelScope.launch(Dispatchers.IO) {
            Repository.updateTransaction(
                beneficiary,
                Repository.parseDouble(amount),
                remarks,
                context
            )
        }
    }
}