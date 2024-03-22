package com.ata.core.domain.usecase

import com.ata.core.data.datasource.local.entity.Friend
import com.ata.core.domain.repository.FriendRepository
import com.ata.core.util.Resource
import javax.inject.Inject

class RemoveFriendsUseCase @Inject constructor(
    private val repository: FriendRepository
) {

    suspend operator fun invoke(): Resource<Friend> {
        return try {
            repository.removeFriends()
            Resource.Success()
        } catch (e: Exception) {
            Resource.Error(e.message!!)
        }
    }

}