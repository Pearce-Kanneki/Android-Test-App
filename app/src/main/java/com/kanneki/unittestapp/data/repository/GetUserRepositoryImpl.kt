package com.kanneki.unittestapp.data.repository

import com.kanneki.unittestapp.data.fake.UserData
import com.kanneki.unittestapp.domain.repository.GetUserRepository
import com.kanneki.unittestapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetUserRepositoryImpl(): GetUserRepository {

    override fun getUserData(account: String?, password: String?): Flow<Resource<UserData>> = flow {
        getUserList().find {
            it.account == account && it.password == password
        }?.let { data ->
            emit(Resource.Success(data))
        } ?: run {
            emit(Resource.Error("Not Find"))
        }

    }

    private fun getUserList() = listOf(
        UserData.Root,
        UserData.FirstUser,
        UserData.SecondUser,
        UserData.Thirduser
    )
}

