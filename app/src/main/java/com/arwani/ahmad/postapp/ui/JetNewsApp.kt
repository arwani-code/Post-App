package com.arwani.ahmad.postapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arwani.ahmad.postapp.ui.home.HomeScreen
import com.arwani.ahmad.postapp.ui.navigation.Screen

@Composable
fun JetNewsApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
  NavHost(navController = navController, startDestination = Screen.Home.route ){
    composable(Screen.Home.route){
        HomeScreen()
    }
  }
}