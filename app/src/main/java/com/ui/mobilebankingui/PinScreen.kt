package com.ui.mobilebankingui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.compose.material3.ButtonDefaults


@Composable
fun PinScreen(navController: NavHostController) {

    var pin by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(painter = painterResource(id = R.drawable.login), contentDescription = "Login image",
            modifier = Modifier.size(200.dp))

        Text(text = "PIN ATM", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(4.dp))

//        Text(text = "Login to your account")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = pin, onValueChange = {
            pin = it
        }, label = {
            Text(text = "Masukan Pin")
        }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(18.dp))

        Button(onClick = {
            Log.i("Credential", "Pin : $pin")
            navController.navigate("verifikasi")
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF024033), // Custom hex color
                contentColor = Color.White
            )) {
            Text(text = "Next")
        }

        Spacer(modifier = Modifier.height(32.dp))

    }
}