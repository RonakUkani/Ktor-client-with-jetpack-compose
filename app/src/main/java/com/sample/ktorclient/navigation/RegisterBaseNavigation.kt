package com.sample.ktorclient.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sample.ktorclient.screens.cart.CartScreen
import com.sample.ktorclient.screens.products.ProductsScreen
import com.sample.ktorclient.screens.splash.SplashScreen

@Composable
fun NavHostController.RegisterBaseNavigation() {
    NavHost(this, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen(this@RegisterBaseNavigation)
        }
        composable(route = Screen.ProductList.route) {
            ProductsScreen(this@RegisterBaseNavigation)
        }
        composable(route = Screen.Cart.route) {
            CartScreen(this@RegisterBaseNavigation)
        }
    }
}