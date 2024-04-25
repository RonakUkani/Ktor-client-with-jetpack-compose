package com.sample.ktorclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.sample.ktorclient.navigation.RegisterBaseNavigation
import com.sample.ktorclient.ui.theme.Orange

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(color = Orange, modifier = Modifier.fillMaxSize()) {
                rememberNavController().RegisterBaseNavigation()
            }
        }
    }

}
