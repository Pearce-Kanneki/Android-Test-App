package com.kanneki.unittestapp.presention.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.rememberNavController
import com.kanneki.unittestapp.presention.home.BottomNavigationBar

@Composable
fun MainPage() {

    val navController = rememberNavController()
    val showBottomBar = remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            if (showBottomBar.value) {
                TopAppBar(
                    title = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Android Test App",
                            textAlign = TextAlign.Center
                        )
                    }
                )
            }
        },
        bottomBar = {
            if (showBottomBar.value)
                BottomNavigationBar(navController = navController)
        }
    ){
        MainScreenNavigationConfigurations(navController = navController, it) { show ->
            showBottomBar.value = show
        }
    }
}