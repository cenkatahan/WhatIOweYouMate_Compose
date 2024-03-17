package com.ata.core.data.datasource.local

import androidx.room.Database
import com.ata.core.data.datasource.local.dao.FriendDao
import com.ata.core.data.datasource.local.entity.Friend

@Database(entities = [Friend::class], version = 1)
abstract class FriendDataBase {
    abstract fun friendDao(): FriendDao

}