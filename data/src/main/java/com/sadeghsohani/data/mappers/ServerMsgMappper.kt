package com.sadeghsohani.data.mappers

import com.sadeghsohani.domain.models.responses.ServerMsgResponse
import com.sadeghsohani.domain.models.datamodels.ServerMsgModel
import javax.inject.Inject

class ServerMsgMappper @Inject constructor() {

    fun toShareDetails(serverMsgResponse: ServerMsgResponse): ServerMsgModel {
        return ServerMsgModel(
            serverMsgResponse.message
        )
    }
}