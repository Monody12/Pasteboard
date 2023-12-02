package com.example.pasteboard.service

import com.baomidou.mybatisplus.extension.service.IService
import com.example.pasteboard.entity.UserToken

interface IUserTokenService : IService<UserToken>
{
    /**
     * 传入用户id，生成token
     */
    fun generateToken(userId: Int): String

    /**
     * 传入用户id和token，判断token是否有效
     */
    fun isTokenValid(userId: Int, token: String): Boolean

    /**
     * 传入token，为token续期
     */
    fun refreshToken(token: String)

    /**
     * 传入token，删除token
     */
    fun deleteToken(token: String)


}
