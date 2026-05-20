package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab04.ui.theme.Lab04Theme
import com.example.lab04.view.TODOScreen
import com.example.lab04.viewModel.GeneralViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab04Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    val viewModel: GeneralViewModel = viewModel<GeneralViewModel>()
                    NavHost(
                        navController = navController,
                        startDestination = "cards_screen",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("cards_screen") {
                            TODOScreen(viewModel = viewModel)
                        }
                    }
                }
            }
        }
    }
}