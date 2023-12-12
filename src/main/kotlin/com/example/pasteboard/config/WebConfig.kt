package com.example.pasteboard.config

import com.example.pasteboard.interceptor.CustomInterceptor
import com.example.pasteboard.interceptor.TraceIdInterceptor
import com.example.pasteboard.service.IUserTokenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
class WebConfig : WebMvcConfigurer {

    @Autowired
    private lateinit var userTokenService: IUserTokenService

    override fun addInterceptors(registry: InterceptorRegistry) {
        // 鉴权拦截器
        val customInterceptor = CustomInterceptor().apply { setUserTokenService(userTokenService) }
        registry.addInterceptor(customInterceptor)
            .addPathPatterns("/**") // 设置拦截的路径规则
            .excludePathPatterns("/user/login","/user/checkToken","/dist/**") // 设置排除的路径规则
        // traceId拦截器
        registry.addInterceptor(traceIdInterceptor())
    }
    @Bean
    fun traceIdInterceptor(): TraceIdInterceptor {
        return TraceIdInterceptor()
    }
}

