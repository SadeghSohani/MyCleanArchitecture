package com.sadeghsohani.domain.usecases

import com.sadeghsohani.domain.models.entities.UserEntity
import com.sadeghsohani.domain.repositories.UserRepo

class SaveUserInDb constructor(
    private val repository: UserRepo
) {
    suspend operator fun invoke(user: UserEntity) : Long = repository.saveUser(user)
}