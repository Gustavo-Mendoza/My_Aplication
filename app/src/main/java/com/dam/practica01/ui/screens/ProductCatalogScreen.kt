
package com.dam.practica01.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

data class Product(val name: String, val price: Double, val category: String, val imageUrl: String)

@Composable
fun ProductCatalogScreen(navController: NavController) {
    val products = listOf(
        Product("Laptop Gamer", 1500.0, "Laptop", "https://picsum.photos/seed/laptop/200/300"),
        Product("Smartphone Pro", 1000.0, "Smartphone", "https://picsum.photos/seed/phone/200/300"),
        Product("Teclado Mecánico", 150.0, "Accesorio", "https://picsum.photos/seed/keyboard/200/300"),
        Product("Monitor 4K", 700.0, "Accesorio", "https://picsum.photos/seed/monitor/200/300")
    )
//DOADASM
    val total = products.sumOf { it.price }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(products) { product ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        AsyncImage(
                            model = product.imageUrl,
                            contentDescription = null,
                            modifier = Modifier
                                .height(150.dp)
                                .fillMaxWidth(),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Nombre: ${product.name}")
                        Text("Precio: $${product.price}")
                        Text("Categoría: ${product.category}")
                    }
                }
            }
        }
        Text("Total: $${total}")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("Volver al Menú")
        }
    }
}
