package com.sample.ktorclient.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sample.ktorclient.R
import com.sample.ktorclient.navigation.Screen
import kotlinx.coroutines.delay

@Preview
@Composable
fun Splash() {
    SplashScreen(navHostController = rememberNavController())
}

@Composable
fun SplashScreen(navHostController: NavHostController) {
    val scale = remember {
        Animatable(0f)
    }

    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 1500,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        // Customize the delay time
        delay(3000L)
        navHostController.navigate(Screen.ProductList.route) {
            popUpTo(Screen.Splash.route) {
                inclusive = true
            }
        }
    }

// Image
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        // Change the logo
        Image(
            painter = painterResource(id = R.drawable.ic_cart_app_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .scale(scale.value)
                .fillMaxSize()
        )
    }
}
