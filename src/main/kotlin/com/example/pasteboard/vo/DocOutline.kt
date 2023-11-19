package com.example.pasteboard.vo

import java.time.LocalDateTime

data class DocOutline (
    val id: Int,
    val userId: Int,
    val title: String,
    var createTime: LocalDateTime? = null,
    val updateTime: LocalDateTime? = null
) {
    constructor(): this(
        id = 0,
        userId = 0,
        title = "",
        createTime = null,
        updateTime = null
    )
}
