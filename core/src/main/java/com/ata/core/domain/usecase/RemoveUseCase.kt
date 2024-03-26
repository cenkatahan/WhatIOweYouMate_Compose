package com.ata.core.domain.usecase

import com.ata.core.data.datasource.local.entity.Friend
import com.ata.core.domain.repository.FriendRepository
import com.ata.core.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoveUseCase @Inject constructor(
    private val repository: FriendRepository
) {
    operator fun invoke(friend: Friend): Flow<Resource<Friend>> {
        return flow { repository.remove(friend) }
    }

}