package com.example.appdea_mmos.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appdea_mmos.navigation.Screens

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow), //boja pozadine
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
                text = "Dobro došli!\n\n",
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color.Black // Boja teksta
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    //TODO: Navigate to Home Screen
                    navController.navigate(Screens.Home.route)
                },
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(Color.Blue), //boja ispune gumba
                modifier = Modifier
                    .padding(5.dp)
            ) {
                Text(
                    text = "Senzor svjetla",
                    modifier = Modifier.padding(5.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.Yellow // Boja teksta
                )
            }
        }
    }
}

@Composable
@Preview
fun LoginScreenPreview() {
    val navController = rememberNavController()
    LoginScreen(navController)
}
