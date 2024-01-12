package com.example.appdea_mmos.screens.home

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appdea_mmos.navigation.Screens
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(navController: NavController) {
    var lightSensorValue by remember { mutableStateOf(0f) }

    val context = LocalContext.current

    DisposableEffect(Unit) {
        val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        val sensorEventListener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                if (event?.sensor?.type == Sensor.TYPE_LIGHT) {
                    lightSensorValue = event.values[0]
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                // Ignore
            }
        }

        sensorManager.registerListener(sensorEventListener, lightSensor, SensorManager.SENSOR_DELAY_NORMAL)

        onDispose {
            sensorManager.unregisterListener(sensorEventListener)
        }
    }

    HomeScreenContent(lightSensorValue, navController)
}

@Composable
fun HomeScreenContent(lightSensorValue: Float, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black), //boja pozadine
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Intenzitet svjetlosti: $lightSensorValue\n${brightness(lightSensorValue)}",
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color.White // Boja teksta
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(Color.Cyan),
                modifier = Modifier.padding(5.dp),
                onClick = {
                    //TODO: Navigate to Details
                    navController.navigate(Screens.Detail.route)
                }
            ) {
                Text(
                    text = "Izlaz",
                    modifier = Modifier.padding(5.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.Black // Boja teksta
                )
            }
        }
    }
}

private fun brightness(brightness: Float): String {
    return when (brightness.toInt()) {
        0 -> "Mrkli mrak"
        in 1..10 -> "Tamno"
        in 11..50 -> "Sjena (sivo)"
        in 51..5000 -> "Normalno"
        in 5001..25000 -> "Nevjerojatno svijetlo  "
        else -> "Zasljepljujuće svijetlo"
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController)
}
