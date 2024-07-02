package com.ui.mobilebankingui

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
fun TransferScreen(navController: NavHostController, viewModel: SharedViewModel) {

    var bank by remember {
        mutableStateOf("")
    }

    var rekening by remember {
        mutableStateOf("")
    }

    var jumlah by remember {
        mutableStateOf("")
    }

    // State for saldo and transfer amount
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "Login image",
            modifier = Modifier.size(200.dp)
        )

        Text(
            text = "Transfer",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = bank,
            onValueChange = {
                bank = it
            },
            label = {
                Text(text = "Nama Bank")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = rekening,
            onValueChange = {
                rekening = it
            },
            label = {
                Text(text = "Rekening")
            }
        )

        Spacer(modifier = Modifier.height(18.dp))

        OutlinedTextField(
            value = jumlah,
            onValueChange = {
                jumlah = it
            },
            label = {
                Text(text = "Jumlah (Rupiah)")
            }
        )

        Spacer(modifier = Modifier.height(18.dp))

        Button(
            onClick = {
                if (jumlah.isNotEmpty()) {
                    val amount = jumlah.toDoubleOrNull()
//                    val amount = 20000
                    if (amount != null && amount > 0) {
                        viewModel.saldo -= amount // Kurangi saldo di ViewModel
                        navController.navigate("pin")                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0F67B1), // Custom hex color
                contentColor = Color.White
            )
        ) {
            Text(text = "Next")
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}
