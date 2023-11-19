package com.example.pasteboard

import com.example.pasteboard.entity.User
import com.example.pasteboard.mapper.DocMapper
import com.example.pasteboard.mapper.UserMapper
import com.example.pasteboard.service.IDocService
import com.example.pasteboard.service.IUserService
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
class ApplicationTest{

    @Autowired
    private lateinit var userMapper: UserMapper

    fun contextLoads() {

    }

    @Test
    fun userInsertTest() {
        val user = User().apply {
            username = "test2"
            password = "test2"
            email = "user2@test.com"
        }
        userMapper.insert(user)
    }

}
