package com.kanneki.unittestapp.presention.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {

    val textValue = mutableStateOf("")
    val openDialog = mutableStateOf(false)

    fun changePageNoValue(): Boolean {
        return textValue.value.isNotBlank()
    }

}