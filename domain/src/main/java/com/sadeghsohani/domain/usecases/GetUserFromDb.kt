package com.sadeghsohani.domain.usecases

import com.sadeghsohani.domain.models.entities.UserEntity
import com.sadeghsohani.domain.repositories.UserRepo

class GetUserFromDb constructor(
    private val repository: UserRepo
) {
    suspend operator fun invoke() : UserEntity? = repository.getUser()
}