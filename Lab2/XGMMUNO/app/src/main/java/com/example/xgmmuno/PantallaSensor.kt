package com.example.xgmmuno

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.xgmmuno.ui.theme.*

@Composable
fun PantallaSensor() {
    // Usamos el hook
    val lightValues = useSensor(Sensor.TYPE_LIGHT)
    val intensidad = lightValues.getOrElse(0) { 0f }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(FondoPastel),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sensor de Luz", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = AzulSuave)
            Text(text = "Intensidad: $intensidad lx", fontSize = 18.sp, color = AzulClaro)
        }
    }
}

@Composable
fun useSensor(sensorType: Int): List<Float> {
    val context = LocalContext.current
    val sensorManager = remember { context.getSystemService(Context.SENSOR_SERVICE) as SensorManager }
    val sensor = sensorManager.getDefaultSensor(sensorType) ?: return emptyList()
    var sensorValues by remember { mutableStateOf(listOf(0f, 0f, 0f)) }

    DisposableEffect(sensorType) {
        val listener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                event?.values?.let {
                    sensorValues = it.toList()
                }
            }
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
        }
        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)
        onDispose {
            sensorManager.unregisterListener(listener)
        }
    }
    return sensorValues
}