package com.kanneki.unittestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kanneki.unittestapp.data.BottomNavigationScreen
import com.kanneki.unittestapp.data.Screen
import com.kanneki.unittestapp.presention.account.AccountPage
import com.kanneki.unittestapp.presention.detail.DetailPage
import com.kanneki.unittestapp.presention.home.BottomNavigationBar
import com.kanneki.unittestapp.presention.home.HomePage
import com.kanneki.unittestapp.presention.home.HomeViewModel
import com.kanneki.unittestapp.presention.list.ListPage
import com.kanneki.unittestapp.presention.main.MainPage
import com.kanneki.unittestapp.presention.main.MainScreenNavigationConfigurations
import com.kanneki.unittestapp.ui.theme.UnitTestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitTestAppTheme {
                
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Main.route
                    ) {
                        composable(Screen.Main.route) {
                            MainPage(navController)
                        }
                        composable("${Screen.Detail.route}/{contentString}") {
                            DetailPage(navController ,it.arguments?.getString("contentString"))
                        }
                        composable(Screen.Detail.route) {
                            DetailPage(navController ,value = null)
                        }
                    }
                }
            }
        }
    }
}


