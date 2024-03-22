package com.ata.core.domain.usecase

import com.ata.core.data.datasource.local.entity.Friend
import com.ata.core.domain.repository.FriendRepository
import com.ata.core.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetFriendsUseCase @Inject constructor(
    private val repository: FriendRepository
) {

    suspend operator fun invoke(): Flow<List<Friend>> {
        return flow {
            emit(repository.getFriends())
        }
    }
}