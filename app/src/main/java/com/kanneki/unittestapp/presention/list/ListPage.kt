package com.kanneki.unittestapp.presention.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kanneki.unittestapp.domain.module.ShowData
import com.kanneki.unittestapp.util.UtilTag.TAG_FLOAT_ACTION_BUTTON_ADD
import com.kanneki.unittestapp.util.UtilTag.TAG_ITEMS_LIST

@Composable
fun ListPage(viewModel: ListViewModel = hiltViewModel()) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.testTag(TAG_FLOAT_ACTION_BUTTON_ADD),
                onClick = { viewModel.addData() }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add",
                    tint = Color.White
                )
            }
        }
    ) {
        LazyColumn(modifier = Modifier.testTag(TAG_ITEMS_LIST)) {
            items(items = viewModel.list, key = { it.id }) { data ->
                ListItem(data = data)
            }
        }
    }
}

@Composable
fun ListItem(data: ShowData) {
    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier.padding(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = data.title,
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = data.content,
                style = MaterialTheme.typography.body2
            )
        }
    }
}