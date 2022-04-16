package com.kanneki.unittestapp.presention.list

import androidx.lifecycle.ViewModel
import com.kanneki.unittestapp.data.module.ShowData

class ListViewModel : ViewModel() {

    val list = mutableListOf<ShowData>()

    init {
        fakeData(20)
    }

    fun fakeData(listCount: Int) {
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
}