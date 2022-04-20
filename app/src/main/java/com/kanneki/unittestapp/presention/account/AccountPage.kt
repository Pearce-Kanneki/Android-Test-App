package com.kanneki.unittestapp.presention.account

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kanneki.unittestapp.R
import com.kanneki.unittestapp.util.UtilTag.TAG_BUTTON_SEND_USER_DATA
import com.kanneki.unittestapp.util.UtilTag.TAG_TEXT_FIELD_USER_ACCOUNT
import com.kanneki.unittestapp.util.UtilTag.TAG_TEXT_FIELD_USER_PASSWORD
import com.kanneki.unittestapp.util.UtilTag.TAG_TEXT_NOT_VALUE_MESSAGE
import com.kanneki.unittestapp.util.UtilTag.TAG_TEXT_VALUE_MESSAGE

@Composable
fun AccountPage(viewModel: AccountViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
                .padding(end = 20.dp)
                .testTag(TAG_TEXT_FIELD_USER_ACCOUNT),
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
                .padding(end = 20.dp)
                .testTag(TAG_TEXT_FIELD_USER_PASSWORD),
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
                .padding(end = 20.dp)
                .testTag(TAG_BUTTON_SEND_USER_DATA),
            onClick = { viewModel.sendData() }
        ) {
            Text(stringResource(id = R.string.button_send))
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (viewModel.loginData.value == null) {
            Text(
                modifier = Modifier.testTag(TAG_TEXT_NOT_VALUE_MESSAGE),
                text = viewModel.message.value ?: ""
            )
        } else {
            Text(
                modifier = Modifier.testTag(TAG_TEXT_VALUE_MESSAGE),
                text = stringResource(
                    id = R.string.account_page_welcome_user,
                    viewModel.loginData.value?.userName ?: ""
                )
            )
        }
    }
}