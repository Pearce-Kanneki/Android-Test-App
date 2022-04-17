package com.kanneki.unittestapp.domain.use_case

import com.kanneki.unittestapp.data.fake.UserData
import com.kanneki.unittestapp.domain.repository.GetUserRepository
import com.kanneki.unittestapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetFindUserInfo(
    private val repository: GetUserRepository
) {

    operator fun invoke(account: String?, password: String?): Flow<Resource<UserData>> {
        return when{
            account?.isBlank() == true -> flow { emit(Resource.Error("Not Account")) }
            password?.isBlank() == true -> flow { emit(Resource.Error("Not Password")) }
            else ->repository.getUserData(account, password)
        }
    }
}