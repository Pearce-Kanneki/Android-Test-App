package com.kanneki.unittestapp.presention.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    val textValue = mutableStateOf("")
    val openDialog = mutableStateOf(false)

    fun changePageNoValue(): Boolean {
        return textValue.value.isNotBlank()
    }

}