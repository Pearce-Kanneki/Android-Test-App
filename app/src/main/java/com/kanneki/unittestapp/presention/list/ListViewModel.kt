package com.kanneki.unittestapp.presention.list

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.kanneki.unittestapp.domain.module.ShowData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(): ViewModel() {

    companion object {
        const val INIT_LIST_SIZE = 20
    }

    private val _list = mutableStateListOf<ShowData>()
    val list: SnapshotStateList<ShowData> = _list

    init {
        fakeData(INIT_LIST_SIZE)
    }

    private fun fakeData(listCount: Int) {
        for (i in 1..listCount) {
            ShowData(
                id = i,
                title = "Title $i",
                content = "Message $i"
            ).also {
                list.add(it)
            }
        }
    }

    fun addData() {
        ShowData(
            id = list.size + 1,
            title = "New Title ${list.size + 1}",
            content = "Message"
        ).also {
            list.add(it)
        }
    }
}