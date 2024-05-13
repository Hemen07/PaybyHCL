package com.hcl.hclpayby.model

import android.content.Context

class Repository {

    companion object {
        @JvmField
        var customers: MutableList<Customer>? = null

        @JvmField
        val transaction: MutableList<Transaction> = mutableListOf()

        @JvmField
        var loggedInCustomerId: String? = null

        fun init() {
            if (customers.isNullOrEmpty()) {
                //create dummy customers
                customers = mutableListOf()
                customers?.add(
                    0,
                    Customer(
                        mobileNumber = "9480797976",
                        customerId = "111",
                        password = "113",
                        accountHolderName = "vishwanath",
                        accountType = "savings",
                        accountBalance = 10000.00,
                        accountNumber = "123456789",
                        accountCreationDate = "2024-05-11",
                    )
                )
            }
        }

        fun setLoggedInCustomerID(customerId: String) {
            loggedInCustomerId = customerId
        }

        fun getLoggedInCustomerID(): String {
            return loggedInCustomerId ?: ""
        }

        fun getCustomers() = customers

        fun getLoggedInCustomerBalance(): Double {
            val customerObject = customers?.find {
                it.customerId == getLoggedInCustomerID()
            }
            return customerObject?.accountBalance ?: 0.0
        }

        fun getLoggedInCustomer(): Customer? {
            return customers?.find {
                it.customerId == getLoggedInCustomerID()
            }
        }

        fun updateTransaction(
            beneficiary: Customer,
            amount: Double,
            remarks: String,
            context: Context
        ) {
            val loggedInCustomer = getLoggedInCustomer()
            if (loggedInCustomer != null) {
                transaction.add(
                    transaction.lastIndex + 1,
                    Transaction(
                        sourceAccountNumber = loggedInCustomer.accountNumber,
                        destinationAccountNumber = beneficiary.accountNumber,
                        amount = amount,
                        remarks = remarks,
                        transactionDate = "2024-05-09",
                        TransactionType = "DR",
                    )
                )
                loggedInCustomer.accountBalance = loggedInCustomer.accountBalance - amount
            }
        }


        fun parseDouble(s: String?): Double {
            if (s == null || s.trim().isEmpty()) {
                return 0.0
            }

            val number = try {
                s.trim().toDouble()
            } catch (e: NumberFormatException) {
                0.0
            }
            return number
        }
    }
}