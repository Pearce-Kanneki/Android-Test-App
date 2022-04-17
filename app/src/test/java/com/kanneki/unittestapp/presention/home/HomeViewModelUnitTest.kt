package com.kanneki.unittestapp.presention.home

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class HomeViewModelUnitTest {

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        viewModel = HomeViewModel()
    }

    @Test
    fun `Text value is empty, changer page return false`() {
        viewModel.textValue.value = ""
        val testResult = viewModel.changePageNoValue()

        assertThat(testResult).isFalse()
    }

    @Test
    fun `Text value is no empty, changer page return true`() {
        viewModel.textValue.value = "test"
        val testResult = viewModel.changePageNoValue()

        assertThat(testResult).isTrue()
    }
}