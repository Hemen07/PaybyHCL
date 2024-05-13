package com.hcl.hclpayby.fundtransafer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.DialogFragment
import com.hcl.hclpaybay.R

class Otpgeneration(
    private val viewModel: FundTransferViewModel,
    private val onSuccess: () -> Unit,
    private val onError: () -> Unit,
    private val onClose: () -> Unit
) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val dialog = this
        return ComposeView(requireContext()).apply {
            setContent {
                Scaffold(content = {
                    SetUpOtp(
                        onSuccess,
                        onError,
                        onClose,
                        dialog
                    )
                })
            }
        }
    }
}

@Composable
fun SetUpOtp(
    onSuccess: () -> Unit,
    onError: () -> Unit,
    onClose: () -> Unit,
    dialog: Otpgeneration
) {
    var otp by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(
            value = otp,
            onValueChange = { newText ->
                otp = newText
            },
            label = { Text(stringResource(R.string.enter_otp)) },
            modifier = Modifier.padding(15.dp)
        )
        Button(
            modifier = Modifier.padding(start = 15.dp),
            enabled = otp != null && otp.trim().length == 4,
            onClick = {
                if (otp != null && otp.trim().length == 4 && otp.equals("5050")) {
                    onSuccess()
                    dialog.dismiss()
                } else {
                    onError()
                }
            }
        ) {
            Text(text = "verify")
        }
    }
}