package com.hcl.hclpayby.model

data class Transaction(
    var sourceAccountNumber: String,
    var destinationAccountNumber: String,
    var amount: Double,
    var remarks: String,
    var transactionDate: String,
    var TransactionType: String,
)
