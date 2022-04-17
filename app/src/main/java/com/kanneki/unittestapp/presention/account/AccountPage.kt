package com.kanneki.unittestapp.presention.account

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.kanneki.unittestapp.R

@Composable
fun AccountPage(viewModel: AccountViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
                .padding(end = 20.dp),
            value = viewModel.account.value ?: "",
            onValueChange = { viewModel.setAccount(it)},
            label = { Text(stringResource(id = R.string.account_page_account_hint)) },
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
                .padding(end = 20.dp),
            value = viewModel.password.value ?: "",
            onValueChange = { viewModel.setPassword(it)},
            label = { Text(stringResource(id = R.string.account_page_password_hint)) },
            visualTransformation = PasswordVisualTransformation(),
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
                .padding(end = 20.dp),
            onClick = { viewModel.sendData() }
        ) {
            Text(stringResource(id = R.string.button_send))
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (viewModel.loginData.value == null) {
            Text(text = viewModel.message.value ?: "")
        } else {
            Text(
                text = stringResource(id = R.string.account_page_welcome_user)
                        + viewModel.loginData.value?.userName
            )
        }
    }
}