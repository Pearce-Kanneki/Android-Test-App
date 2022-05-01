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
        viewModel.setNewAccount(newValue)

        assertThat(viewModel.account).startsWith(newValue)
    }

    @Test
    fun `Set Account empty value`() {
        viewModel.setNewAccount(null)

        assertThat(viewModel.account).isNull()
    }

    @Test
    fun `Set Password new value`() {
        val newValue = "Test Password"
        viewModel.setNewPassword(newValue)

        assertThat(viewModel.password).startsWith(newValue)
    }

    @Test
    fun `Set Password empty value`() {
        viewModel.setNewPassword(null)

        assertThat(viewModel.password).isNull()
    }
}