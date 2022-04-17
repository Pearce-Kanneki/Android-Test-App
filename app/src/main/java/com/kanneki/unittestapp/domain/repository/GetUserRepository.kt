package com.kanneki.unittestapp.domain.repository

import com.kanneki.unittestapp.data.fake.UserData
import com.kanneki.unittestapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface GetUserRepository {

    fun getUserData(account: String?, password: String?):Flow<Resource<UserData>>
}