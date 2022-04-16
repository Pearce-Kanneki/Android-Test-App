package com.kanneki.unittestapp.presention.main

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kanneki.unittestapp.presention.home.BottomNavigationBar

@Composable
fun MainPage(navController: NavHostController) {
    val nav = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Android Test App",
                        textAlign = TextAlign.Center
                    )
                }
            )
        },
        content = {
            MainScreenNavigationConfigurations(navController = navController, mainNav = nav, it)
        },
        bottomBar = {
            BottomNavigationBar(navController = nav)
        }
    )
}