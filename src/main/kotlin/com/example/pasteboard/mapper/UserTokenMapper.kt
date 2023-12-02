package com.example.pasteboard.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.example.pasteboard.entity.UserToken

interface UserTokenMapper : BaseMapper<UserToken> {
    fun selectByUserIdAndToken(userId: Int, token: String): UserToken?
}
