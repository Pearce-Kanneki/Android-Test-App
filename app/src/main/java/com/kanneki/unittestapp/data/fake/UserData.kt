package com.kanneki.unittestapp.data.fake

sealed class UserData(
    val userName: String,
    val account: String,
    val password: String,
    val message: String?
){
    object Root: UserData(
        userName = "Root",
        account = "root",
        password = "abc123",
        message = "Admin"
    )
    object FirstUser: UserData(
        userName = "Yoshida",
        account = "yuko",
        password = "shadow0928",
        message = "Shamiko"
    )
    object SecondUser: UserData(
        userName = "Chiyoda",
        account = "momo",
        password = "momo0325",
        message = ""
    )
    object Thirduser: UserData(
        userName = "Hinatsuki",
        account = "mikan",
        password = "mikan1103",
        message = ""
    )
}
