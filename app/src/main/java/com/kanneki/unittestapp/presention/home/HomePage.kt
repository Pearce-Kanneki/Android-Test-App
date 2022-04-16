package com.kanneki.unittestapp.presention.home


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kanneki.unittestapp.R
import com.kanneki.unittestapp.data.Screen

@Composable
fun HomePage(navHostController: NavHostController, viewModel: HomeViewModel) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = viewModel.textValue.value,
                onValueChange = { viewModel.textValue.value = it },
                label = { Text(stringResource(id = R.string.text_field_label_text)) },
                maxLines = 1,
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
                    .padding(end = 20.dp),
                onClick = { navHostController.navigate(Screen.Detail.route + "/${viewModel.textValue.value}") }
            ) {
                Text(stringResource(id = R.string.button_home_change_page_value))
            }

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
                    .padding(end = 20.dp),
                onClick = { navHostController.navigate(Screen.Detail.route) }
            ) {
                Text(stringResource(id = R.string.button_home_change_page_no_value))
            }
        }
    }
}