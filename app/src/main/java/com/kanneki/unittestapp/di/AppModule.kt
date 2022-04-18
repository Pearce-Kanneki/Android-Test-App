package com.kanneki.unittestapp.di

import com.kanneki.unittestapp.data.repository.GetUserRepositoryImpl
import com.kanneki.unittestapp.domain.repository.GetUserRepository
import com.kanneki.unittestapp.domain.use_case.GetFindUserInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGetFindUserInfo(repository: GetUserRepository): GetFindUserInfo {
        return GetFindUserInfo(repository)
    }

    @Provides
    @Singleton
    fun provideGetUserRepository(): GetUserRepository {
        return GetUserRepositoryImpl()
    }
}