package com.mshetty.instagramcompose.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mshetty.instagramcompose.data.BottomNavItem
import com.mshetty.instagramcompose.ui.theme.*

@Composable
fun MainScreen() {
    val navHostController = rememberNavController()
    return Scaffold(bottomBar = { BottomBar(navController = navHostController)}) {
        BottomNavGraph(navHostController = navHostController)
    }
}

@Composable
fun BottomBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.SEARCH,
        BottomNavItem.PROFILE
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    
    BottomNavigation(backgroundColor = white) {
        items.forEach { screens ->
            AddItem(screen = screens, currentDestination = currentDestination, navController = navController )
        }
        
    }
}

@Composable
fun RowScope.AddItem(screen:BottomNavItem, currentDestination:NavDestination?, navController: NavController) {
    BottomNavigationItem(
        icon =  { Icon(painterResource(id = screen.icon,),contentDescription = null) },
        selected = currentDestination?.hierarchy?.any {
             it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(ContentAlpha.disabled) ,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }
    )
}