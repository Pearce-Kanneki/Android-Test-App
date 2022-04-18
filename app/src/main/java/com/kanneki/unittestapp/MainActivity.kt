package com.kanneki.unittestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kanneki.unittestapp.data.Screen
import com.kanneki.unittestapp.presention.detail.DetailPage
import com.kanneki.unittestapp.presention.main.MainPage
import com.kanneki.unittestapp.ui.theme.UnitTestAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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


