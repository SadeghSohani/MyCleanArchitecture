package com.sadeghsohani.domain.repositories

import com.sadeghsohani.domain.models.entities.UserEntity

interface UserRepo {

    suspend fun saveUser(user: UserEntity) : Long
    suspend fun getUser() : UserEntity

}