package com.joseph.data

import io.ktor.http.cio.websocket.*
import kotlinx.coroutines.isActive

data class Room(
    val name: String,
    val maxPlayers: Int,
    var players: List<Player> = listOf()
) {
    suspend fun broadcast(message: String) {
        for (player in players) {
            if (player.socket.isActive) {
                player.socket.send(Frame.Text(message))
            }
        }
    }

    suspend fun broadcastToAllExcept(message: String, clientId: String) {
        for (player in players) {
            if (player.clientId != clientId && player.socket.isActive) {
                player.socket.send(Frame.Text(message))
            }
        }
    }
}
