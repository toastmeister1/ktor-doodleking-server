package com.joseph.data.models

import com.joseph.other.Constants.TYPE_GAME_ERROR

data class GameError(
    val errorType: Int
) : BaseModel(TYPE_GAME_ERROR) {

    companion object {
        const val ERROR_ROOM_NOT_FOUND = 0
    }
}
