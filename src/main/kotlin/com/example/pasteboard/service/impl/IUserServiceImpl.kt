package com.example.pasteboard.service.impl

import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.pasteboard.entity.User
import com.example.pasteboard.mapper.UserMapper
import com.example.pasteboard.service.IUserService
import com.example.pasteboard.service.IUserTokenService
import com.example.pasteboard.vo.UserLogin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class IUserServiceImpl : ServiceImpl<UserMapper, User>(), IUserService {

    @Autowired
    private lateinit var userMapper: UserMapper
    @Autowired
    private lateinit var userTokenService: IUserTokenService

    /**
     * 用户登录
     * TODO 用户不存在异常、密码错误异常
     * @param username 用户名
     * @param password 密码
     * @return 返回用户登录信息
     */
    override fun login(username: String, password: String): UserLogin? {
        val ktQueryWrapper = KtQueryWrapper(User::class.java).eq(User::username, username)
        val user = userMapper.selectOne(ktQueryWrapper)
        if (user == null) {
            // TODO 报错用户不存在
            return null
        }
        if (!user.password.equals(password)) {
            // TODO 报错密码错误
            return null
        }
        // 生成token
        val token = userTokenService.generateToken(user.id!!)
        return UserLogin(user, token)

    }
}
