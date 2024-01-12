package com.example.appdea_mmos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appdea_mmos.screens.detail.DetailScreen
import com.example.appdea_mmos.screens.home.HomeScreen
import com.example.appdea_mmos.screens.login.LoginScreen


@Composable
fun NavGraph (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.Login.route)
    {
        composable(route = Screens.Login.route){
            LoginScreen(navController)
        }
        composable(route = Screens.Home.route){
            HomeScreen(navController)
        }
        composable(route = Screens.Detail.route){
            DetailScreen()
        }
    }
}
