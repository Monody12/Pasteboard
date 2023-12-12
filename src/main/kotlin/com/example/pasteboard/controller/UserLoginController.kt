package com.example.pasteboard.controller

import com.example.pasteboard.entity.ApiResponse
import com.example.pasteboard.service.IUserService
import com.example.pasteboard.service.IUserTokenService
import com.example.pasteboard.vo.UserLoginInput
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserLoginController {

    @Autowired
    private lateinit var userService: IUserService
    @Autowired
    private lateinit var userTokenService: IUserTokenService

    @PostMapping("/login")
    fun login(@RequestBody userLoginInput: UserLoginInput): ApiResponse<Any?> {
        val userLogin = userService.login(userLoginInput.username, userLoginInput.password)
            ?: return ApiResponse.loginError("用户名或密码错误")
        return ApiResponse.success(userLogin)
    }

    /**
     * 校验token
     */
    @GetMapping("/checkToken")
    fun checkToken(
        @RequestHeader("Authorization") token: String,
        @RequestHeader("Uid") uid: Int,
    ): ApiResponse<out Any?> {
        val valid = userTokenService.isTokenValid(uid, token)
        if (!valid){
            return ApiResponse.unauthorized("token无效")
        }
        return ApiResponse.success()
    }
}
