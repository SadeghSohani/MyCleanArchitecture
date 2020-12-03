package com.sadeghsohani.domain.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0
@Entity
data class UserEntity(
    val id : Int? = null,
    val name : String? = null,
    val family : String? = null
) {
    @PrimaryKey(autoGenerate = false)
    var userId: Int = CURRENT_USER_ID
}