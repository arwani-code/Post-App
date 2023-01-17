package com.arwani.ahmad.postapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arwani.ahmad.postapp.data.local.entity.PostsEntity
import com.arwani.ahmad.postapp.ui.add.AddScreen
import com.arwani.ahmad.postapp.ui.detail.DetailScreen
import com.arwani.ahmad.postapp.ui.home.HomeScreen
import com.arwani.ahmad.postapp.ui.navigation.Screen
import com.arwani.ahmad.postapp.ui.search.SearchScreen

@Composable
fun JetNewsApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.Detail.route) {
            val posts =
                navController.previousBackStackEntry?.savedStateHandle?.get<PostsEntity>("posts")
            if (posts != null) {
                DetailScreen(navController = navController, posts = posts)
            }
        }
        composable(Screen.Add.route) {
            AddScreen(navController = navController)
        }
        composable(Screen.Search.route) {
            SearchScreen(navController = navController)
        }
    }
}