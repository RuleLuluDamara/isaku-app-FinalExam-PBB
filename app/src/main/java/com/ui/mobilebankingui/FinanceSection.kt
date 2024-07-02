package com.ui.mobilebankingui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Upload
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ui.mobilebankingui.data.Finance
import com.ui.mobilebankingui.ui.theme.BlueStart

val financeList = listOf(
    Finance(
        icon = Icons.Rounded.Money,
        name = "Transfer",
        background = BlueStart
    ),
    Finance(
        icon = Icons.Rounded.Upload,
        name = "TopUp",
        background = BlueStart
    ),
    Finance(
        icon = Icons.Rounded.AttachMoney,
        name = "Saldo",
        background = BlueStart
    ),
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "Finance",
        background = BlueStart
    ),
    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "Transactions",
        background = BlueStart
    ),
)

@Composable
fun FinanceSection(navController: NavHostController) {
    Column {
        Text(
            text = "Menu",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        LazyRow {
            items(financeList.size) { index ->
                FinanceItem(index, navController)
            }
        }
    }
}

@Composable
fun FinanceItem(index: Int, navController: NavHostController) {
    val finance = financeList[index]
    var lastPaddingEnd = 0.dp
    if (index == financeList.size - 1) {
        lastPaddingEnd = 16.dp
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastPaddingEnd)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable {
                    if (finance.name == "Transfer") {
                        navController.navigate("transfer")
                    } else if (finance.name == "TopUp") {
                        // Add additional condition logic here
                        navController.navigate("topup")
                    }
                }
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.background)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White
                )
            }
            Text(
                text = finance.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )
        }
    }
}

@Preview
@Composable
fun PreviewFinanceSection() {
    val navController = rememberNavController()
    FinanceSection(navController)
}
