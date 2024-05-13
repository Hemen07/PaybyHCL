package com.hcl.hclpayby.model

data class Customer(
    val mobileNumber: String,
    val customerId: String,
    val password: String,
    val accountHolderName: String,
    val accountType: String,
    var accountBalance: Double,
    val accountNumber: String,
    val accountCreationDate: String,
)
