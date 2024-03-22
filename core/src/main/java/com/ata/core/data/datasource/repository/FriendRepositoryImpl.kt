package com.ata.core.data.datasource.repository

import com.ata.core.data.datasource.local.dao.FriendDao
import com.ata.core.data.datasource.local.entity.Friend
import com.ata.core.domain.repository.FriendRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FriendRepositoryImpl @Inject constructor(
    private val dao: FriendDao
) : FriendRepository {
    override fun add(friend: Friend) = dao.save(friend)
    override fun remove(friend: Friend) = dao.delete(friend)
    override fun update(friend: Friend) = dao.update(friend)
    override fun getFriendBy(id: Int): Friend = dao.getFriend(id)
    override fun getFriends(): List<Friend> = dao.getFriends()
    override fun removeFriends() = dao.deleteAll()

}