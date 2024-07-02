package com.ui.mobilebankingui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ui.mobilebankingui.ui.theme.MobileBankingUITheme
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileBankingUITheme {
                val navController = rememberNavController()
                val viewModel: SharedViewModel = viewModel()

                SetBarColor(color = MaterialTheme.colorScheme.background)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") { LoginScreen(navController) }
                        composable("register") { Register(navController) }
                        composable("home") { HomeScreen(navController, viewModel) }
                        composable("transfer") { TransferScreen(navController, viewModel) }
                        composable("topup") { TopUpScreen(navController,    viewModel) }
                        composable("va") { VirtualAccountScreen(navController) }
                        composable("pin") { PinScreen(navController)}
                        composable("verifikasi") { VerificationScreen(navController)}

                    }
                }
            }
        }
    }

    @Composable
    private fun SetBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }
}


@Composable
fun HomeScreen(navController: NavHostController, viewModel: SharedViewModel) {

    Scaffold (
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ){
        padding ->
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(padding)) {
            WalletSection(viewModel)
            CardsSection()
            Spacer(modifier = Modifier.height(8.dp))
            FinanceSection(navController)
            CurrenciesSection()
        }

    }
}
