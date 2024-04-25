package com.sample.ktorclient.navigation

sealed class Screen(val route: String) {
    data object Splash: Screen("Splash")
    data object ProductList: Screen("productList")
    data object Cart: Screen("cart")
}