package com.arwani.ahmad.postapp.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object Detail : Screen("Detail")
    object Search : Screen("Search")
    object Add : Screen("Add")
}