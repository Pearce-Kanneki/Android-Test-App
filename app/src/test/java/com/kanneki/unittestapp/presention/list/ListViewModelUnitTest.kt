package com.kanneki.unittestapp.presention.list

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ListViewModelUnitTest {

    private lateinit var viewModel: ListViewModel

    @Before
    fun setUp() {
        viewModel = ListViewModel()
    }

    @Test
    fun `View Model init, list size 10`() {

        assertThat(viewModel.list).isNotEmpty()
        assertThat(viewModel.list.size).isEqualTo(ListViewModel.INIT_LIST_SIZE)
    }

    @Test
    fun `Add data, list size 11`() {
        viewModel.addData()

        assertThat(viewModel.list.size).isEqualTo(ListViewModel.INIT_LIST_SIZE + 1)
    }

    @Test
    fun `List data, get item 3 data`() {
        val data = viewModel.list[2]

        assertThat(data.id).isEqualTo(3)
        assertThat(data.title).isEqualTo("Title 3")
        assertThat(data.content).isEqualTo("Message 3")
    }

    @Test
    fun `add data, get new data`() {
        viewModel.addData()
        val data = viewModel.list.last()

        assertThat(data.id).isEqualTo(11)
        assertThat(data.title).isEqualTo("New Title 11")
        assertThat(data.content).isEqualTo("Message")
    }
}