package com.example.pasteboard.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.pasteboard.entity.User
import com.example.pasteboard.mapper.UserMapper
import com.example.pasteboard.service.IUserService
import org.springframework.stereotype.Service

@Service
class IUserServiceImpl : ServiceImpl<UserMapper, User>(), IUserService
