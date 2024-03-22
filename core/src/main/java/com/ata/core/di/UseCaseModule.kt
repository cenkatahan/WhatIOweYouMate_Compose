package com.ata.core.di

import com.ata.core.data.datasource.local.dao.FriendDao
import com.ata.core.data.datasource.repository.FriendRepositoryImpl
import com.ata.core.domain.repository.FriendRepository
import com.ata.core.domain.usecase.GetFriendsUseCase
import com.ata.core.domain.usecase.RemoveFriendsUseCase
import com.ata.core.domain.usecase.RemoveUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

//    @Provides
//    @Singleton
//    fun provideRemoveUseCase(repository: FriendRepository): RemoveUseCase =
//        RemoveUseCase(repository)
//
//    @Provides
//    @Singleton
//    fun provideRemoveFriendUseCase(repository: FriendRepository): RemoveFriendsUseCase =
//        RemoveFriendsUseCase(repository)
//
//    @Provides
//    @Singleton
//    fun provideGetFriendsFriendUseCase(repository: FriendRepository): GetFriendsUseCase =
//        GetFriendsUseCase(repository)
}