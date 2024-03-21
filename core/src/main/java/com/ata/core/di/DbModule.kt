package com.ata.core.di

import android.content.Context
import androidx.room.Room
import com.ata.core.data.datasource.local.FriendDataBase
import com.ata.core.util.TableConstants.TABLE_FRIEND
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideAppDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, FriendDataBase::class.java, TABLE_FRIEND)
            .allowMainThreadQueries()
            .build()

    @Provides
    @Singleton
    fun provideDao(dataBase: FriendDataBase) = dataBase.friendDao()


}