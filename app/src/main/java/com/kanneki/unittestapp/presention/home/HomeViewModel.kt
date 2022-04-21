package com.kanneki.unittestapp.presention.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {

    var textValue by mutableStateOf("")
    var openDialog by mutableStateOf(false)

    fun setNewTextValue(value: String) {
        textValue = value
    }

    fun changePageNoValue(): Boolean {
        return textValue.isNotBlank()
    }

}