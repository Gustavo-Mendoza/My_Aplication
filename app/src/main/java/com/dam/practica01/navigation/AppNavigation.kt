
package com.dam.practica01.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dam.practica01.ui.screens.CurrencyConverterScreen
import com.dam.practica01.ui.screens.DogAgeScreen
import com.dam.practica01.ui.screens.MenuScreen
import com.dam.practica01.ui.screens.ProductCatalogScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") { MenuScreen(navController) }
        composable("edadCanina") { DogAgeScreen(navController) }
        composable("divisas") { CurrencyConverterScreen(navController) }
        composable("catalogo") { ProductCatalogScreen(navController) }
    }
}
