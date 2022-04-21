package com.kanneki.unittestapp.presention.account

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kanneki.unittestapp.data.fake.UserData
import com.kanneki.unittestapp.domain.use_case.GetFindUserInfo
import com.kanneki.unittestapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val getFindUserInfo: GetFindUserInfo
) : ViewModel() {
    var account by mutableStateOf<String?>("")
    var password by mutableStateOf<String?>("")
    var loginData by mutableStateOf<UserData?>(null)
    var message by mutableStateOf<String?>("")

    fun setNewAccount(value: String?) {
        account = value
    }

    fun setNewPassword(value: String?) {
        password = value
    }

    fun sendData() {
        viewModelScope.launch {
            getFindUserInfo.invoke(account, password).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        loginData = result.data
                        message = result.message
                    }
                    is Resource.Error -> {
                        loginData = null
                        message = result.message
                    }
                }
            }.launchIn(this)
        }
    }
}