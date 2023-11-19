package com.example.pasteboard.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.example.pasteboard.entity.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper : BaseMapper<User>

