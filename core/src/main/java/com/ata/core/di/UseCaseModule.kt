package com.ata.core.di

import com.ata.core.domain.repository.FriendRepository
import com.ata.core.domain.usecase.GetFriendsUseCase
import com.ata.core.domain.usecase.RemoveFriendsUseCase
import com.ata.core.domain.usecase.RemoveUseCase
import com.ata.core.domain.usecase.SaveFriendUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideRemoveUseCase(repository: FriendRepository): RemoveUseCase =
        RemoveUseCase(repository)

    @Provides
    fun provideRemoveFriendUseCase(repository: FriendRepository): RemoveFriendsUseCase =
        RemoveFriendsUseCase(repository)

    @Provides
    fun provideGetFriendsFriendUseCase(repository: FriendRepository): GetFriendsUseCase =
        GetFriendsUseCase(repository)

    @Provides
    fun provideSaveFriendUseCase(repository: FriendRepository): SaveFriendUseCase =
        SaveFriendUseCase(repository)
}