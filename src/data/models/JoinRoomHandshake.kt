package com.joseph.data.models

import com.joseph.other.Constants.TYPE_JOIN_ROOM_HANDSHAKE

data class JoinRoomHandshake(
    val username: String,
    val roomName: String,
    val clientId: String
) : BaseModel(TYPE_JOIN_ROOM_HANDSHAKE)
