package com.example.xgmmuno

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge //ok
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable //
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.xgmmuno.ui.theme.*

@Serializable object DestinoHome
@Serializable object DestinoLista
@Serializable object DestinoSensor
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XGMMUNOTheme {
                // El NavController
                val navController = rememberNavController()

                // El NavHost que define las rutas
                NavHost(navController = navController, startDestination = DestinoHome) {
                    composable<DestinoHome> {
                        PantallaHome(
                            onIrALista = { navController.navigate(DestinoLista) },
                            onIrASensor = { navController.navigate(DestinoSensor) }
                        )
                    }
                    composable<DestinoLista> {
                        PantallaRegistros()
                    }
                    composable<DestinoSensor> {
                        PantallaSensor()
                    }
                }
            }
        }
    }
}
