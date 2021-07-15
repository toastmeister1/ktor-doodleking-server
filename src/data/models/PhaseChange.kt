package com.joseph.data.models

import com.joseph.data.Room
import com.joseph.other.Constants.TYPE_PHASE_CHANGE

data class PhaseChange(
    var phase: Room.Phase?,
    var time: Long,
    val drawingPlayer: String? = null
): BaseModel(TYPE_PHASE_CHANGE)
