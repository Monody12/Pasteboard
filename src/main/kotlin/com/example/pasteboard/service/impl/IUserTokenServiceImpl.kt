package com.example.pasteboard.service.impl

import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.pasteboard.entity.UserToken
import com.example.pasteboard.mapper.UserTokenMapper
import com.example.pasteboard.service.IUserTokenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class IUserTokenServiceImpl : ServiceImpl<UserTokenMapper, UserToken>(), IUserTokenService {
    /**
     * token过期天数
     */
    private val tokenExpireDays = 7

    @Autowired
    private lateinit var userTokenMapper: UserTokenMapper

    override fun generateToken(userId: Int): String {
        var userToken = UserToken().apply {
            this.userId = userId
            token = UUID.randomUUID().toString()
            expireTime = LocalDateTime.now().plusDays(tokenExpireDays.toLong())
        }
        userTokenMapper.insert(userToken)
        return userToken.token!!
    }

    override fun isTokenValid(userId: Int, token: String): Boolean {
        var userToken = userTokenMapper.selectByUserIdAndToken(userId, token)
        if (userToken == null) {
            // TODO 报错token不存在
            return false
        }
        // TODO 报错token已过期
        return userToken.expireTime!!.isAfter(LocalDateTime.now())
    }

    override fun refreshToken(token: String) {
        val ktQueryWrapper = KtQueryWrapper(UserToken::class.java).eq(UserToken::token, token)
        val userToken = userTokenMapper.selectOne(ktQueryWrapper)
        if (userToken == null) {
            // TODO 报错token不存在
            return
        }
        userToken.expireTime = LocalDateTime.now().plusDays(tokenExpireDays.toLong())
        userTokenMapper.updateById(userToken)
    }

    override fun deleteToken(token: String) {
        val ktQueryWrapper = KtQueryWrapper(UserToken::class.java).eq(UserToken::token, token)
        userTokenMapper.delete(ktQueryWrapper)
    }

}
