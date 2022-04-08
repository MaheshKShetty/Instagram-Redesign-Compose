package com.mshetty.instagramcompose.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mshetty.instagramcompose.data.BottomNavItem

@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = BottomNavItem.Home.route) {
        composable(route = BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(route = BottomNavItem.SEARCH.route) {
            SearchScreen()
        }
        composable(route = BottomNavItem.PROFILE.route) {
            ProfileScreen()
        }
    }

}