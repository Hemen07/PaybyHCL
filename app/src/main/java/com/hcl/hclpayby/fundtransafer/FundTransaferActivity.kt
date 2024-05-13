package com.hcl.hclpayby.fundtransafer

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.hcl.hclpaybay.R
import com.hcl.hclpayby.model.Customer
import com.hcl.hclpayby.model.Repository

class FundTransaferActivity : AppCompatActivity() {

    lateinit var viewModel: FundTransferViewModel
    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Repository.init()
        initViewModel()
        fragmentManager = supportFragmentManager
        setContent {
            Scaffold(
                topBar = {

                },
                content = { paddingValues ->
                    FundTransferScreen(viewModel, this, fragmentManager)
                }
            )
        }
        viewModel.getCustomers(this)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[FundTransferViewModel::class.java]
    }
}

@Composable
fun FundTransferScreen(
    viewModel: FundTransferViewModel,
    context: Context,
    fragmentManager: FragmentManager
) {
    val customers = viewModel.customer.collectAsState().value
    if (customers is Result.Loading) {

    } else if (customers is Result.Success) {
        customers.data?.let { SuccessScreen(viewModel, context, it, fragmentManager) }
    } else if (customers is Result.Error) {

    }
}

@Composable
fun SuccessScreen(
    viewModel: FundTransferViewModel,
    context: Context,
    data: List<Customer>,
    fragmentManager: FragmentManager
) {
    // Remember the selected item
    var selectedItem by remember { mutableStateOf(0) }
    // Remember whether the dropdown menu is expanded
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
        ) {
            IconButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { expanded = !expanded }) {
                Row() {
                    Text(
                        text = "Beneficiary name " + data[selectedItem].accountHolderName ?: "",
                    )
                    //SetDropDownArrow(expanded = expanded)
                }
            }
            DropdownMenu(modifier = Modifier
                .width(400.dp)
                .height(50.dp),
                expanded = expanded,
                onDismissRequest = { expanded = false }) {
                data.forEachIndexed { index, item ->
                    DropdownMenuItem(onClick = {
                        selectedItem = index
                        expanded = false
                    }) {
                        Text(text = item.accountHolderName)
                    }
                }
            }
        }

        ShowBenificiaryDetaisl(viewModel, context, data[selectedItem], fragmentManager)
    }
}

@Composable
fun SetDropDownArrow(expanded: Boolean) {
    Icon(
        modifier = Modifier.rotate(
            if (expanded) 180f
            else 360f
        ), imageVector = Icons.Filled.ArrowDropDown, contentDescription = "More"
    )
}

@Composable
fun ShowBenificiaryDetaisl(
    viewModel: FundTransferViewModel,
    context: Context,
    beneficiary: Customer,
    fragmentManager: FragmentManager
) {
    // Remember the value entered in the text field
    var remarks by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxHeight()
    ) {
        Column(
            modifier = Modifier.weight(1f, true), verticalArrangement = Arrangement.Top
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = stringResource(R.string.beneficiary_name),
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 15.sp
                )
            )
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = "${beneficiary.accountHolderName}",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp
                )
            )
            Spacer(Modifier.size(25.dp))
            Text(
                text = stringResource(R.string.beneficiary_account_number),
                modifier = Modifier.padding(10.dp),
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            )
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = "${beneficiary.accountNumber}",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp
                )
            )
            TextField(
                value = amount,
                onValueChange = { newText ->
                    amount = newText
                },
                label = { Text(stringResource(R.string.enter_amount)) },
                modifier = Modifier.padding(15.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            val enteredAmount = Repository.parseDouble(amount)
            if (enteredAmount > viewModel.loggedCustomersBalance!!) {
                Text(
                    text = stringResource(R.string.amount_is_exceeded_your_balance),
                    color = Color.Red,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            TextField(
                value = remarks,
                onValueChange = { newText ->
                    remarks = newText
                },
                label = { Text(stringResource(R.string.enter_remarks)) },
                modifier = Modifier.padding(15.dp)
            )
        }

        Button(
            enabled = Repository.parseDouble(amount) > 0.00,
            onClick = {
                openOtp(beneficiary, amount, remarks, viewModel, context, fragmentManager)
            },
            modifier = Modifier.padding(start = 10.dp)
                .width(300.dp)
        ) {
            Text(text = stringResource(R.string.transfer))
        }
    }
}

fun openOtp(
    beneficiary: Customer,
    amount: String,
    remarks: String,
    viewModel: FundTransferViewModel,
    context: Context,
    fragmentManager: FragmentManager
) {
    val otpgeneration = Otpgeneration(
        viewModel,
        onSuccess = {
            viewModel.transfer(
                beneficiary,
                amount,
                remarks,
                context
            )
        },
        onError = {
            Toast.makeText(
                context,
                "wrong otp",
                Toast.LENGTH_SHORT
            ).show()
        },
        onClose = {

        }
    )
    otpgeneration.setCancelable(false)
    otpgeneration.show(fragmentManager, "")
}
