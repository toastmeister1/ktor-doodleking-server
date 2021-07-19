package com.joseph.data.models

data class PlayerData(
    val username: String,
    val isDrawing: Boolean = false,
    val score: Int = 0,
    var rank: Int = 0
)
