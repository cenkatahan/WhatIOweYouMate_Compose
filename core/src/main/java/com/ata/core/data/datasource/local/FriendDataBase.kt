package com.ata.core.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ata.core.data.datasource.local.dao.FriendDao
import com.ata.core.data.datasource.local.entity.Friend

@Database(entities = [Friend::class], version = 1, exportSchema = false)
abstract class FriendDataBase: RoomDatabase() {
    abstract fun friendDao(): FriendDao

}