package com.example.pasteboard.controller

import com.example.pasteboard.service.IUserService
import com.example.pasteboard.vo.UserLoginInput
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserLogin {

    @Autowired
    private lateinit var userService: IUserService

    @PostMapping("/login")
    fun login(@RequestBody userLoginInput: UserLoginInput): com.example.pasteboard.vo.UserLogin {
        val userLogin = userService.login(userLoginInput.username, userLoginInput.password)
        return userLogin ?: com.example.pasteboard.vo.UserLogin()
    }
}
