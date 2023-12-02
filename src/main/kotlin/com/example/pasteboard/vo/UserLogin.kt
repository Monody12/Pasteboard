package com.example.pasteboard.vo

import com.example.pasteboard.entity.User

/**
 * 用户登录
 * 包含用户信息和token
 */
data class UserLogin(
    val user :User? = null,
    val token: String? = null
){
    constructor(): this(
        user = null,
        token = null
    )
}
