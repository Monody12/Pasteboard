package com.example.pasteboard.vo

data class UserLoginInput (
    val username: String,
    val password: String
) {
    constructor(): this(
        username = "",
        password = ""
    )
}
