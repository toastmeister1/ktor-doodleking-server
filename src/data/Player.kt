package com.joseph.data

import io.ktor.http.cio.websocket.*

data class Player(
    val username: String,
    var socket: WebSocketSession,
    val clientId: String,
    val isDrawing: Boolean,
    val score: Int = 0,
    val rank: Int = 0
)