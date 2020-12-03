package com.sadeghsohani.domain.usecases

import com.sadeghsohani.domain.models.datamodels.ServerMsgModel
import com.sadeghsohani.domain.repositories.ServerMsgRepo

class ServerMessage constructor(private val repository: ServerMsgRepo) {
    suspend operator fun invoke(phone: String) : ServerMsgModel = repository.getServerMsg(phone)
}