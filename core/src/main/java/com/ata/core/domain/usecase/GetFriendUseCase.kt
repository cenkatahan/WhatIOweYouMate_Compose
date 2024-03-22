package com.ata.core.domain.usecase

import com.ata.core.data.datasource.local.entity.Friend
import com.ata.core.domain.repository.FriendRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

//maybe not necessary.
class GetFriendUseCase @Inject constructor(
    private val repository: FriendRepository
) {
    suspend operator fun invoke(id: Int): Flow<Friend> = flow { emit(repository.getFriendBy(id)) }
}