package com.ata.core.di

import com.ata.core.data.datasource.local.dao.FriendDao
import com.ata.core.data.datasource.repository.FriendRepositoryImpl
import com.ata.core.domain.repository.FriendRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(dao: FriendDao): FriendRepository = FriendRepositoryImpl(dao)
}