package com.sadeghsohani.data.repositories

import com.sadeghsohani.data.datasource.db.AppDatabase
import com.sadeghsohani.domain.models.entities.UserEntity
import com.sadeghsohani.domain.repositories.UserRepo
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val db: AppDatabase
) : UserRepo {

    override suspend fun saveUser(user: UserEntity): Long = db.getUserDao().insert(user)

    override suspend fun getUser(): UserEntity = db.getUserDao().getUser()

}