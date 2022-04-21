package com.kanneki.unittestapp.presention.home

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kanneki.unittestapp.data.BottomNavigationScreen

val bottomNavigationItems = listOf(
    BottomNavigationScreen.Home,
    BottomNavigationScreen.List,
    BottomNavigationScreen.Account
)

@Composable
fun BottomNavigationBar(navController: NavController) {

    BottomAppBar(
        cutoutShape = CircleShape,
        content = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                bottomNavigationItems.forEach{ item ->
                    BottomNavigationItem(
                        selected = currentRoute == item.rounte,
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.rounte
                            )
                        },
                        label = { Text(stringResource(id = item.resourceId)) },
                        alwaysShowLabel = true,
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.White.copy(alpha = .4f),
                        onClick = {
                            if (currentRoute != item.rounte) {
                                navController.navigate(item.rounte){
                                    popUpTo(navController.graph.findStartDestination().id){
                                        saveState = false
                                    }
                                    launchSingleTop = true
                                    restoreState = false
                                }
                            }
                        }
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun NavigationPreView() {
    val navController = rememberNavController()
    BottomNavigationBar(navController)
}

@Composable
fun CurrentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString("AAA")

}