package com.joseph.other

import com.joseph.data.models.ChatMessage

fun ChatMessage.matchesWord(word: String): Boolean {
    return message.toLowerCase().trim() == word.toLowerCase().trim()
}