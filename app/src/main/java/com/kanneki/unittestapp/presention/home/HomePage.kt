package com.kanneki.unittestapp.presention.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kanneki.unittestapp.R
import com.kanneki.unittestapp.data.Screen
import com.kanneki.unittestapp.presention.compose.MessageDialog
import com.kanneki.unittestapp.util.UtilTag.TAG_BUTTON_NOT_VALUE
import com.kanneki.unittestapp.util.UtilTag.TAG_BUTTON_VALUE
import com.kanneki.unittestapp.util.UtilTag.TAG_DIALOG_MESSAGE
import com.kanneki.unittestapp.util.UtilTag.TAG_TEXT_FIELD_PAGE_INDEX

@Composable
fun HomePage(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize()) {
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
                    .testTag(TAG_TEXT_FIELD_PAGE_INDEX),
                value = viewModel.textValue,
                onValueChange = (viewModel::setNewTextValue),
                label = { Text(stringResource(id = R.string.text_field_label_text)) },
                maxLines = 1,
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
                    .padding(end = 20.dp)
                    .testTag(TAG_BUTTON_VALUE),
                onClick = {
                    if (viewModel.changePageNoValue()) {
                        navHostController.navigate("${Screen.Detail.route}/${viewModel.textValue}")
                    } else {
                        viewModel.openDialog = true
                    }
                }
            ) {
                Text(stringResource(id = R.string.button_home_change_page_value))
            }

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
                    .padding(end = 20.dp)
                    .testTag(TAG_BUTTON_NOT_VALUE),
                onClick = { navHostController.navigate(Screen.Detail.route) }
            ) {
                Text(stringResource(id = R.string.button_home_change_page_no_value))
            }
        }
    }

    if (viewModel.openDialog) {
        MessageDialog(
            modifier = Modifier.testTag(TAG_DIALOG_MESSAGE),
            title = stringResource(id = R.string.message_dialog_title),
            message = stringResource(id = R.string.message_dialog_message_no_value),
            onDismiss = {
                viewModel.openDialog = false
            }
        )
    }
}