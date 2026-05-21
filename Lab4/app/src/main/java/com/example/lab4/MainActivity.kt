package com.example.lab4

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
import com.example.lab4.ui.theme.Lab4Theme
import com.example.lab4.view.TODOScreen
import com.example.lab4.viewModel.GeneralViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    val viewModel: GeneralViewModel = viewModel()

                    NavHost(
                        navController = navController,
                        startDestination = "todo_screen",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("todo_screen") {
                            TODOScreen(viewModel = viewModel)
                        }
                    }
                }
            }
        }
    }
}
