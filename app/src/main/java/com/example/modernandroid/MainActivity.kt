package com.example.modernandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.modernandroid.feature.greeting.GreetingScreen
import com.example.modernandroid.feature.profile.ProfileScreen
import com.example.modernandroid.ui.theme.ProyekMobilePertemuan1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyekMobilePertemuan1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Menyimpan status halaman mana yang sedang dibuka ("greeting" atau "profile")
                    var currentScreen by remember { mutableStateOf("greeting") }

                    // Logika perpindahan halaman
                    when (currentScreen) {
                        "greeting" -> GreetingScreen(
                            onNavigateToProfile = { currentScreen = "profile" }
                        )
                        "profile" -> ProfileScreen(
                            onNavigateToGreeting = { currentScreen = "greeting" }
                        )
                    }
                }
            }
        }
    }
}