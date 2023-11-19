package com.example.pasteboard.config

import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Configuration

@Configuration
@MapperScan("com.example.pasteboard.mapper")
class MyBatisConfig
