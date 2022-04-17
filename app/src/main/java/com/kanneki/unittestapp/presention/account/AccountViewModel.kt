package com.kanneki.unittestapp.presention.account

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kanneki.unittestapp.R
import com.kanneki.unittestapp.data.fake.UserData
import com.kanneki.unittestapp.domain.use_case.GetFindUserInfo
import com.kanneki.unittestapp.util.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class AccountViewModel(private val getFindUserInfo: GetFindUserInfo): ViewModel() {
    private val _account = mutableStateOf<String?>("")
    val account:State<String?> = _account
    private val _password = mutableStateOf<String?>("")
    val password:State<String?> = _password
    private val _loginData = mutableStateOf<UserData?>(null)
    val loginData: State<UserData?> = _loginData

    private val _message = mutableStateOf<String?>("")
    val message: State<String?> = _message

    fun setAccount(value: String?) {
        _account.value = value
    }

    fun setPassword(value: String?) {
        _password.value = value
    }

    fun sendData() {
        viewModelScope.launch {
            getFindUserInfo.invoke(account.value, password.value).onEach { result ->
                when(result) {
                    is Resource.Success -> {
                        _loginData.value = result.data
                        _message.value = result.message
                    }
                    is Resource.Error -> {
                        _loginData.value = null
                        _message.value = result.message
                    }
                }
            }.launchIn(this)
        }
    }
}