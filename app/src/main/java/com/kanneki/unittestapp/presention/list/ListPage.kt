package com.kanneki.unittestapp.presention.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kanneki.unittestapp.data.module.ShowData

@Composable
fun ListPage(padding:PaddingValues, viewModel: ListViewModel) {
    LazyColumn(modifier = Modifier.padding(bottom = padding.calculateBottomPadding())) {
        items(count = viewModel.list.count()){ index ->
            ListItem(data = viewModel.list[index])
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
            modifier = Modifier.fillMaxWidth().padding(16.dp),
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