package com.joseph.data.models

import com.joseph.other.Constants.TYPE_PLAYER_LIST

data class PlayersList(
    val players: List<PlayerData>
) : BaseModel(TYPE_PLAYER_LIST)
