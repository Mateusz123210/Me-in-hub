package com.example.meinhub.ui.screens


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun ComposeNavigation(navController: NavHostController, innerPadding: PaddingValues) {

    NavHost(navController = navController, startDestination = "MainScreen"){
        composable("MainScreen"){
            MainScreenContent(navController, innerPadding = innerPadding)
        }
        composable("Books/{id}"){
                navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getString("id")
            id?.let { id->
                BookScreenContent(navController, innerPadding = innerPadding, id = id.toInt())
            }
        }
        composable("Footballers/{id}"){
                navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getString("id")
            id?.let { id->
                FootballerScreenContent(navController, innerPadding = innerPadding, id = id.toInt())
            }
        }
        composable("Cars/{id}"){
                navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getString("id")
            id?.let { id->
                CarScreenContent(navController, innerPadding = innerPadding, id = id.toInt())
            }
        }
    }
}