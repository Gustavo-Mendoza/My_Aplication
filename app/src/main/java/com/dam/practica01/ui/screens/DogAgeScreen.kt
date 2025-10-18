
package com.dam.practica01.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogAgeScreen(navController: NavController) {
    var age by rememberSaveable { mutableStateOf("") }
    var selectedSize by rememberSaveable { mutableStateOf("Pequeño") }
    var result by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val sizes = listOf("Pequeño", "Mediano", "Grande")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Edad del perro (años humanos)") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                value = selectedSize,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                sizes.forEach { size ->
                    DropdownMenuItem(
                        text = { Text(text = size) },
                        onClick = {
                            selectedSize = size
                            expanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val ageInt = age.toIntOrNull()
            if (ageInt != null && ageInt > 0) {
                val dogAge = when (selectedSize) {
                    "Pequeño" -> ageInt * 5
                    "Mediano" -> ageInt * 6
                    else -> ageInt * 7
                }
                result = "¡Tu perro tiene $dogAge años en edad canina! ¡Qué sabio!"
            } else {
                result = "Por favor, ingresa una edad válida."
            }
        }) {
            Text("Calcular Edad")
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
