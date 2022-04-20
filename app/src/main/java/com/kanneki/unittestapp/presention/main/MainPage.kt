package com.kanneki.unittestapp.presention.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = if (showBottomBar.value) "Android Test App" else "Detail",
                        textAlign = TextAlign.Start
                    )
                },
                navigationIcon = {
                    if (!showBottomBar.value) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
                        }
                    }

                }
            )
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