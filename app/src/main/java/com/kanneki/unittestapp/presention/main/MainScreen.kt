package com.kanneki.unittestapp.presention.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kanneki.unittestapp.data.BottomNavigationScreen
import com.kanneki.unittestapp.data.repository.GetUserRepositoryImpl
import com.kanneki.unittestapp.domain.use_case.GetFindUserInfo
import com.kanneki.unittestapp.presention.account.AccountPage
import com.kanneki.unittestapp.presention.account.AccountViewModel
import com.kanneki.unittestapp.presention.home.HomePage
import com.kanneki.unittestapp.presention.home.HomeViewModel
import com.kanneki.unittestapp.presention.list.ListPage
import com.kanneki.unittestapp.presention.list.ListViewModel

@Composable
fun MainScreenNavigationConfigurations(
    navController: NavHostController,
    mainNav: NavHostController,
    padding: PaddingValues
) {

    NavHost(
        navController = mainNav,
        startDestination = BottomNavigationScreen.Home.rounte
    ) {
        composable(BottomNavigationScreen.Home.rounte) {
            HomePage(navController, HomeViewModel())
        }
        composable(BottomNavigationScreen.List.rounte) {
            ListPage(padding,ListViewModel())
        }
        composable(BottomNavigationScreen.Account.rounte) {
            AccountPage(AccountViewModel(GetFindUserInfo(GetUserRepositoryImpl())))
        }
    }
}
