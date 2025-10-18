
package com.dam.practica01.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CurrencyConverterScreen(navController: NavController) {
    var amount by rememberSaveable { mutableStateOf("") }
    var conversionType by rememberSaveable { mutableStateOf("USD → PEN") }
    var result by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Monto") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            RadioButton(
                selected = conversionType == "USD → PEN",
                onClick = { conversionType = "USD → PEN" }
            )
            Text("USD → PEN")
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(
                selected = conversionType == "PEN → USD",
                onClick = { conversionType = "PEN → USD" }
            )
            Text("PEN → USD")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val amountDouble = amount.toDoubleOrNull()
            if (amountDouble != null) {
                val convertedAmount = if (conversionType == "USD → PEN") {
                    amountDouble * 3.80
                } else {
                    amountDouble / 3.80
                }
                val currencySymbol = if (conversionType == "USD → PEN") "S/" else "$"
                result = "$currencySymbol${String.format("%.2f", convertedAmount)}"
            } else {
                result = "Por favor, ingresa un monto válido."
            }
        }) {
            Text("Convertir")
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (result.isNotEmpty()) {
            Text(result)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("Volver al Menú")
        }
    }
}
