package com.sadeghsohani.data.datasource.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sadeghsohani.domain.models.entities.CURRENT_USER_ID
import com.sadeghsohani.domain.models.entities.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserEntity) : Long

    /*
    table name must be exactly userEntity
     */
    @Query("SELECT * FROM userEntity WHERE userId = $CURRENT_USER_ID")
    suspend fun getUser() : UserEntity

}