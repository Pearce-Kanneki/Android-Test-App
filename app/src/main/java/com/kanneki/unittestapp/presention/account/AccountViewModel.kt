package com.kanneki.unittestapp.presention.account

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AccountViewModel: ViewModel() {
    val account = mutableStateOf("")
    val password = mutableStateOf("")

    val message = mutableStateOf("")

    fun sendData() {
        if (account.value.isNotBlank() && password.value.isNotBlank()) {
            message.value = "已輸入"
        }
    }
}