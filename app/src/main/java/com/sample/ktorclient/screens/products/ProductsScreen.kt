package com.sample.ktorclient.screens.products

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sample.ktorclient.navigation.Screen

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Product() {
    ProductsScreen(rememberNavController())
}

@Composable
fun ProductsScreen(navHostController: NavHostController) {
    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        Scaffold(
            floatingActionButton = {
                CartButton{
                    navHostController.navigate(Screen.Cart.route)
                }
            }
        ) { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
            )

        }
    }

}

@Composable
fun CartButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
    ) {
        Icon(Icons.Filled.ShoppingCart, "Floating action button.")
    }
}