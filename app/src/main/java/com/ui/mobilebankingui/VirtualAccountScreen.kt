package com.ui.mobilebankingui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.compose.material3.ButtonDefaults


@Composable
fun VirtualAccountScreen(navController: NavHostController) {

    var va_acc by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(painter = painterResource(id = R.drawable.login), contentDescription = "Login image",
            modifier = Modifier.size(200.dp))

        Text(text = "This is Your Virtual account", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text(text = "088081234567890", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(4.dp))

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("verifikasi")
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0F67B1), // Custom hex color
                contentColor = Color.White
            )) {
            Text(text = "Next")
        }

        Spacer(modifier = Modifier.height(32.dp))


    }
}