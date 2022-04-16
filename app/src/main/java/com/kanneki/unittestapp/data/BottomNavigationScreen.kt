package com.kanneki.unittestapp.data

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.kanneki.unittestapp.R

sealed class BottomNavigationScreen(
    val rounte: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector
){
    object Home: BottomNavigationScreen(Screen.Home.route, R.string.navigation_route_home, Icons.Filled.Home)
    object List: BottomNavigationScreen(Screen.List.route, R.string.navigation_route_list, Icons.Filled.List)
    object Account: BottomNavigationScreen(Screen.Account.route, R.string.navigation_route_account, Icons.Filled.Person)
}
