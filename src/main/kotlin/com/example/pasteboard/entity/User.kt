package com.example.pasteboard.entity

import com.baomidou.mybatisplus.annotation.*
import java.time.LocalDateTime

// 用户表，中包含字段 主键id自增，用户名，密码，邮箱，创建时间，更新时间，是否删除
data class User(
    @TableId(type = IdType.AUTO)
    var id: Int? = null,
    var username: String? = null,
    var password: String? = null,
    var email: String? = null,
    @TableField(fill = FieldFill.INSERT)
    var createTime: LocalDateTime? = null,
    @TableField(fill = FieldFill.INSERT_UPDATE)
    var updateTime: LocalDateTime? = null,
    @TableLogic
    var deleteFlag: Boolean? = null
){
    constructor(): this(
        id = null,
        username = null,
        password = null,
        email = null,
        createTime = null,
        updateTime = null,
        deleteFlag = null
    )
}
