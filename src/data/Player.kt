package com.joseph.data

import com.joseph.data.models.Ping
import com.joseph.gson
import com.joseph.other.Constants.PING_FREQUENCY
import com.joseph.server
import io.ktor.http.cio.websocket.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class Player(
    val username: String,
    var socket: WebSocketSession,
    val clientId: String,
    var isDrawing: Boolean = false,
    var score: Int = 0,
    val rank: Int = 0
) {
    private var pingJob: Job? = null

    private var pingTime = 0L
    private var pongTime = 0L

    var isOnline = true

    fun startPinging() {
        pingJob?.cancel()
        pingJob = GlobalScope.launch {
            while(true) {
                sendPing()
                delay(PING_FREQUENCY)
            }
        }
    }

    private suspend fun sendPing() {
        pingTime = System.currentTimeMillis()
        socket.send(Frame.Text(gson.toJson(Ping())))
        delay(PING_FREQUENCY)
        if(pingTime - pongTime == PING_FREQUENCY) {
            isOnline = false
            server.playerLeft(clientId)
            pingJob?.cancel()
        }
    }

    fun receivedPong() {
        pongTime = System.currentTimeMillis()
        isOnline = true
    }

    fun disconnect() {
        pingJob?.cancel()
    }
}
