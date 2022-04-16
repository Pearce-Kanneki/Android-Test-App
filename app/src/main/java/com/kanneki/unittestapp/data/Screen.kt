package com.kanneki.unittestapp.data

sealed class Screen(val route: String) {
    // 一般頁面
    object Main: Screen("main")
    object Detail: Screen("detail")

    // 主頁使用
    object Home: Screen("home")
    object List: Screen("list")
    object Account: Screen("screen")
}
