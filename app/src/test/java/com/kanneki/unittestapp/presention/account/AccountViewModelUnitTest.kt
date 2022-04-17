package com.kanneki.unittestapp.presention.account

import com.google.common.truth.Truth.assertThat
import com.kanneki.unittestapp.data.repository.GetUserRepositoryImpl
import com.kanneki.unittestapp.domain.repository.GetUserRepository
import com.kanneki.unittestapp.domain.use_case.GetFindUserInfo
import org.junit.Before
import org.junit.Test

class AccountViewModelUnitTest {

    private lateinit var repository: GetUserRepository
    private lateinit var info: GetFindUserInfo
    private lateinit var viewModel: AccountViewModel

    @Before
    fun setUp() {
        repository = GetUserRepositoryImpl()
        info = GetFindUserInfo(repository)
        viewModel = AccountViewModel(info)
    }

    @Test
    fun `Set Account new value`() {
        val newValue = "Test Account"
        viewModel.setAccount(newValue)

        assertThat(viewModel.account.value).startsWith(newValue)
    }

    @Test
    fun `Set Account empty value`() {
        viewModel.setAccount(null)

        assertThat(viewModel.account.value).isNull()
    }

    @Test
    fun `Set Password new value`() {
        val newValue = "Test Password"
        viewModel.setPassword(newValue)

        assertThat(viewModel.password.value).startsWith(newValue)
    }

    @Test
    fun `Set Password empty value`() {
        viewModel.setPassword(null)

        assertThat(viewModel.password.value).isNull()
    }
}