package com.hcl.hclpayby.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginPage()
        }
    }

}

@Composable
private fun LoginPage() {
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // fetching local context
        val mContext = LocalContext.current

        // Declaring two string values
        // for storing username and password
        val mCustomerId = remember { mutableStateOf("") }
        val mPassword = remember { mutableStateOf("") }
        val maxChar = 6

        Text(text = "Login", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive))

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "CustomerId") },
            value = mCustomerId.value,
            onValueChange = {
                if (it.length <= maxChar)
                    mCustomerId.value = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Password") },
            value = mPassword.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = {
                if (it.length <= 8)
                    mPassword.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {
                    if(mCustomerId.value.isEmpty() and mPassword.value.isNotEmpty()){
                        Toast.makeText(mContext, "CustomerId is Empty", Toast.LENGTH_SHORT).show()
                    }
                    else if(mCustomerId.value.length != maxChar){
                        Toast.makeText(mContext, "Max length is required 6 ", Toast.LENGTH_SHORT).show()
                    }
                   else if (mPassword.value.isEmpty() and mCustomerId.value.isNotEmpty()){
                        Toast.makeText(mContext, "Password is Empty", Toast.LENGTH_SHORT).show()
                    }else if(mPassword.value.length != 8){
                        Toast.makeText(mContext, "Max length is required 8", Toast.LENGTH_SHORT).show()

                    } else if(mCustomerId.value.isEmpty() and mPassword.value.isEmpty()){
                        Toast.makeText(mContext, "CustomerId and Password are Empty", Toast.LENGTH_SHORT).show()
                    }
                   else if(isValidCredentials(mPassword)){
                        Toast.makeText(mContext, "Please enter atleast one speacial character", Toast.LENGTH_SHORT).show()
                    }
                  else  if(isValidCustomerId(mCustomerId.toString())){
                        Toast.makeText(mContext, "CustomerId should be entered alpha numeric and max length 6", Toast.LENGTH_SHORT).show()
                    }
                    if(mCustomerId.value.isNotEmpty() and mPassword.value.isNotEmpty()){
                        val intent = Intent(mContext, MainActivity::class.java)
                        mContext.startActivity(intent)
                        Toast.makeText(mContext, "You are Logged In", Toast.LENGTH_SHORT).show()
                    }
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Login")
            }
        }

    }
}

fun isValidCredentials(mPassword: MutableState<String>): Boolean {
    val passwordPattern = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$")
    return  passwordPattern.matches(mPassword.toString())
}

fun isValidCustomerId(customerId: String): Boolean {
    val ALPHANUMERIC_PATTERN = "^[a-zA-Z0-9]+$"
    return customerId.matches(ALPHANUMERIC_PATTERN.toRegex())
}




