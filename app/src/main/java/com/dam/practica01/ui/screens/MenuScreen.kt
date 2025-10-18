
package com.dam.practica01.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate("edadCanina") }) {
            Text("Calculadora de Edad Canina")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("divisas") }) {
            Text("Conversor de Divisas")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("catalogo") }) {
            Text("Catálogo de Productos")
        }
    }
}
