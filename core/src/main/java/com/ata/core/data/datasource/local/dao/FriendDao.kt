package com.ata.core.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ata.core.data.datasource.local.entity.Friend
import com.ata.core.util.TableConstants.TABLE_FRIEND

@Dao
interface FriendDao {
    @Insert
    fun save(friend: Friend)

    @Query("SELECT * FROM $TABLE_FRIEND WHERE id=:id")
    fun getFriend(id: Int): Friend

    @Query("SELECT * FROM $TABLE_FRIEND")
    fun getFriends(): List<Friend>

    @Delete
    fun delete(friend: Friend)

    @Query("DELETE FROM $TABLE_FRIEND")
    fun deleteAll()

    @Update
    fun update(friend: Friend)
}