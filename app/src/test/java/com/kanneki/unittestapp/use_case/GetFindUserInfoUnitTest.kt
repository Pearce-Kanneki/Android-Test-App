package com.kanneki.unittestapp.use_case

import com.google.common.truth.Truth.assertThat
import com.kanneki.unittestapp.data.fake.UserData
import com.kanneki.unittestapp.data.repository.GetUserRepositoryImpl
import com.kanneki.unittestapp.domain.repository.GetUserRepository
import com.kanneki.unittestapp.domain.use_case.GetFindUserInfo
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetFindUserInfoUnitTest {

    private lateinit var repository: GetUserRepository
    private lateinit var info: GetFindUserInfo

    @Before
    fun setUp() {
        repository = GetUserRepositoryImpl()
        info = GetFindUserInfo(repository)
    }

    @Test
    fun `Account value is null, return error`() = runBlocking {
        info.invoke(null, "abc123").collectLatest {

            assertThat(it.data).isNull()
            assertThat(it.message).isNotEmpty()
            assertThat(it.message).isEqualTo("Not Account")
        }
    }

    @Test
    fun `Account value is blank, return error`() = runBlocking {
        info.invoke("", "abc123").collectLatest {

            assertThat(it.data).isNull()
            assertThat(it.message).isNotEmpty()
            assertThat(it.message).isEqualTo("Not Account")
        }
    }

    @Test
    fun `Password value is null, return error`() = runBlocking {
        info.invoke("abc123", null).collectLatest {

            assertThat(it.data).isNull()
            assertThat(it.message).isNotEmpty()
            assertThat(it.message).isEqualTo("Not Password")
        }
    }

    @Test
    fun `Password value is blank, return error`() = runBlocking {
        info.invoke("abc123", "").collectLatest {

            assertThat(it.data).isNull()
            assertThat(it.message).isNotEmpty()
            assertThat(it.message).isEqualTo("Not Password")
        }
    }
    
    @Test
    fun `send user data, data mistake, not find data`() = runBlocking {
        info.invoke("abc","abc").collectLatest {

            assertThat(it.data).isNull()
            assertThat(it.message).isNotEmpty()
            assertThat(it.message).isEqualTo("Not Find")
        }
    }

    @Test
    fun `send user data, data correct, find data`() = runBlocking {
        val data = UserData.Root
        info.invoke(data.account, data.password).collectLatest {

            assertThat(it.message).isNull()
            assertThat(it.data).isNotNull()
            assertThat(it.data?.userName).isEqualTo(data.userName)
            assertThat(it.data?.message).isEqualTo(data.message)
        }
    }
}