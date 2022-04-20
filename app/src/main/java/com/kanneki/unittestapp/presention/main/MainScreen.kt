package com.kanneki.unittestapp.presention.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kanneki.unittestapp.data.BottomNavigationScreen
import com.kanneki.unittestapp.data.Screen
import com.kanneki.unittestapp.presention.account.AccountPage
import com.kanneki.unittestapp.presention.detail.DetailPage
import com.kanneki.unittestapp.presention.home.HomePage
import com.kanneki.unittestapp.presention.list.ListPage

@Composable
fun MainScreenNavigationConfigurations(
    navController: NavHostController,
    padding: PaddingValues,
    callback: (Boolean) -> Unit
) {
    NavHost(
        modifier = Modifier.padding(bottom = padding.calculateBottomPadding()),
        navController = navController,
        startDestination = BottomNavigationScreen.Home.rounte
    ) {
        composable(BottomNavigationScreen.Home.rounte) {
            HomePage(navController)
            callback(true)
        }
        composable(BottomNavigationScreen.List.rounte) {
            ListPage()
            callback(true)
        }
        composable(BottomNavigationScreen.Account.rounte) {
            AccountPage()
            callback(true)
        }

        composable("${Screen.Detail.route}/{contentString}") {
            DetailPage(it.arguments?.getString("contentString"))
            callback(false)
        }
        composable(Screen.Detail.route) {
            DetailPage(value = null)
            callback(false)
        }
    }
}
