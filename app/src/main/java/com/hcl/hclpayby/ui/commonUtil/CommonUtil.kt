package com.hcl.hclpayby.ui.commonUtil

/**
 * All hardcoded data  will be available here
 * TESTING purpose
 */

data class Customer(
    var accountHolderName: String,
    var accountType: ACCOUNT_TYPE,
    var availableBalance: Double,
    var accountNumber: Int,
    var accountDetails: AccountDetails,
    var transactionDetails: List<TransactionDetails>,
    var beneficiaryDetails: List<BeneficiaryDetails>
)

data class AccountDetails(
    var accountNumber: Int,
    var availableBalance: Double,
    var accountCreationDate: String,
)

data class TransactionDetails(
    var accountNumber: Int,
    var amount: Double,
    var remarks: String,
    var transactionDate: String,
    var transactionType: TRANSACTION_TYPE
)

data class BeneficiaryDetails(
    var destinationAccountNumber: Int,
    var beneficiaryName: String
)


enum class ACCOUNT_TYPE {
    SAVINGS, CURRENT
}


enum class TRANSACTION_TYPE {
    CREDIT, DEBIT
}


private fun loadData() {


}

val customerHemen = Customer(
    accountHolderName = "Hemen",
    accountType = ACCOUNT_TYPE.SAVINGS,
    availableBalance = 7000.0,
    accountNumber = 12345,
    accountDetails = AccountDetails(
        accountNumber = 12345,
        availableBalance = 7000.0,
        accountCreationDate = "20/12/2019"
    ),
    transactionDetails = listOf(
        getTransactionsDetails(),
        getTransactionsDetails().apply {
            accountNumber = 1234567
            amount = 200.0
            remarks = "To Uma"
            transactionDate = "11/05/2024"
            transactionType = TRANSACTION_TYPE.DEBIT
        },
        getTransactionsDetails().apply {
            accountNumber = 12345678
            amount = 200.0
            remarks = "From Vishwa"
            transactionDate = "11/05/2024"
            transactionType = TRANSACTION_TYPE.CREDIT
        }),
    beneficiaryDetails = listOf(
        getBeneficiaryDetails(),
        getBeneficiaryDetails().apply {
            destinationAccountNumber = 1234567
            beneficiaryName = "Uma"
        },
        getBeneficiaryDetails().apply {
            destinationAccountNumber = 12345678
            beneficiaryName = "Vishwa"
        },
    )

)
val customerNeha = Customer(
    accountHolderName = "Neha",
    accountType = ACCOUNT_TYPE.SAVINGS,
    availableBalance = 10000.0,
    accountNumber = 123456,
    accountDetails = AccountDetails(
        accountNumber = 123456,
        availableBalance = 10000.0,
        accountCreationDate = "20/12/2019"
    ),
    transactionDetails = listOf(
        getTransactionsDetails(),
        getTransactionsDetails().apply {
            accountNumber = 1234567
            amount = 200.0
            remarks = "To Uma"
            transactionDate = "11/05/2024"
            transactionType = TRANSACTION_TYPE.DEBIT
        },
        getTransactionsDetails().apply {
            accountNumber = 12345678
            amount = 200.0
            remarks = "From Vishwa"
            transactionDate = "11/05/2024"
            transactionType = TRANSACTION_TYPE.CREDIT
        }),
    beneficiaryDetails = listOf(
        getBeneficiaryDetails(),
        getBeneficiaryDetails().apply {
            destinationAccountNumber = 1234567
            beneficiaryName = "Uma"
        },
        getBeneficiaryDetails().apply {
            destinationAccountNumber = 12345678
            beneficiaryName = "Vishwa"
        },
    )

)

val customerBhumi = Customer(
    accountHolderName = "Neha",
    accountType = ACCOUNT_TYPE.SAVINGS,
    availableBalance = 10000.0,
    accountNumber = 1234567890,
    accountDetails = AccountDetails(
        accountNumber = 1234567890,
        availableBalance = 10000.0,
        accountCreationDate = "20/12/2019"
    ),
    transactionDetails = listOf(
        getTransactionsDetails(),
        getTransactionsDetails().apply {
            accountNumber = 1234567
            amount = 200.0
            remarks = "To Uma"
            transactionDate = "11/05/2024"
            transactionType = TRANSACTION_TYPE.DEBIT
        },
        getTransactionsDetails().apply {
            accountNumber = 12345678
            amount = 200.0
            remarks = "From Vishwa"
            transactionDate = "11/05/2024"
            transactionType = TRANSACTION_TYPE.CREDIT
        }),
    beneficiaryDetails = listOf(
        getBeneficiaryDetails(),
        getBeneficiaryDetails().apply {
            destinationAccountNumber = 1234567
            beneficiaryName = "Uma"
        },
        getBeneficiaryDetails().apply {
            destinationAccountNumber = 12345678
            beneficiaryName = "Vishwa"
        },
    )

)

fun getTransactionsDetails(): TransactionDetails {
    return TransactionDetails(
        accountNumber = 123456,
        amount = 100.0,
        remarks = "To Neha",
        transactionDate = "11/05/2024",
        transactionType = TRANSACTION_TYPE.DEBIT
    )
}

fun getBeneficiaryDetails(): BeneficiaryDetails {
    return BeneficiaryDetails(
        destinationAccountNumber = 123456,
        beneficiaryName = "Neha"
    )
}
