package com.example.profilescreenassnmnt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.profilescreenassnmnt.ui.presentation.screens.ProfileScreen
import com.example.profilescreenassnmnt.ui.presentation.screens.ProfileViewModel
import com.example.profilescreenassnmnt.ui.theme.ProfileScreenAssnmntTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        setContent {
            ProfileScreenAssnmntTheme {
                ProfileScreen(
                    profileViewModel = profileViewModel,
                    onAction = profileViewModel::onAction
                )
            }
        }
    }
}