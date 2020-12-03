package com.sadeghsohani.domain.repositories

import com.sadeghsohani.domain.models.datamodels.ServerMsgModel

interface ServerMsgRepo {
    suspend fun getServerMsg(phone: String) : ServerMsgModel
}