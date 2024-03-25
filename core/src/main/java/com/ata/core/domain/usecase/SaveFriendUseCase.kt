package com.ata.core.domain.usecase

import com.ata.core.data.datasource.local.entity.Friend
import com.ata.core.domain.repository.FriendRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SaveFriendUseCase @Inject constructor(
    private val repository: FriendRepository
) {
    suspend operator fun invoke(friend: Friend): Flow<Unit> {
        return flow {
            emit(repository.add(friend))
        }
    }
}