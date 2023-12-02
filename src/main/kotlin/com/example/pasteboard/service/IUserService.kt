package com.example.pasteboard.service

import com.baomidou.mybatisplus.extension.service.IService
import com.example.pasteboard.entity.User
import com.example.pasteboard.vo.UserLogin

interface IUserService : IService<User>{
    /**
     * 用户登录
     * TODO 用户不存在异常、密码错误异常
     * @param username 用户名
     * @param password 密码
     * @return 返回用户信息
     */
    fun login(username: String, password: String): UserLogin?

}
