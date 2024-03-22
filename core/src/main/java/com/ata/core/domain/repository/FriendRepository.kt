package com.ata.core.domain.repository

import com.ata.core.data.datasource.local.entity.Friend

interface FriendRepository {
    fun add(friend: Friend)
    fun remove(friend: Friend)
    fun update(friend: Friend)
    fun getFriendBy(id: Int): Friend
    fun getFriends(): List<Friend>
    fun removeFriends()
}