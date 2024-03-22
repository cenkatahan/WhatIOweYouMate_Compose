package com.ata.core.domain.usecase

import com.ata.core.data.datasource.local.entity.Friend
import com.ata.core.domain.repository.FriendRepository
import com.ata.core.util.Resource
import javax.inject.Inject

class UpdateFriendUseCase @Inject constructor(
    private val repository: FriendRepository
) {
    suspend operator fun invoke(friend: Friend): Resource<Friend> {
        return try {
            repository.update(friend)
            Resource.Success()
        } catch (e: Exception) {
            Resource.Error(e.message!!)
        }
    }
}