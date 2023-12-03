package com.example.pasteboard.interceptor

import com.example.pasteboard.service.IUserTokenService
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CustomInterceptor : HandlerInterceptorAdapter() {

    private lateinit var userTokenService: IUserTokenService

    fun setUserTokenService(userTokenService: IUserTokenService) {
        this.userTokenService = userTokenService
    }

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        // 在请求处理之前进行拦截逻辑的实现
        // 获取 Authorization 和 Uid 这两个请求头
        val token = request.getHeader("Authorization")
        val uid = request.getHeader("Uid")
        if (token == null || uid == null) {
            // TODO 报错token或uid不存在
            response.sendError(401, "token或uid不存在")
            return false
        }
        // 校验 token
        val valid = userTokenService.isTokenValid(uid.toInt(), token)
        if (!valid) {
            // TODO 报错token无效
            response.sendError(401, "token无效")
            return false
        }
        // 返回 true 表示继续处理，返回 false 则中断后续处理
        return true
    }

    // 其他可重写的方法：postHandle、afterCompletion

    /**
     * 请求处理以后为该Token续期
     */
    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, ex: Exception?) {
        // 获取 Authorization 和 Uid 这两个请求头
        val token = request.getHeader("Authorization")
        // 为token续期
        userTokenService.refreshToken(token)
    }
}
