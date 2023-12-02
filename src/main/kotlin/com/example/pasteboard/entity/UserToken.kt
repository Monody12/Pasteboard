package com.example.pasteboard.entity

import com.baomidou.mybatisplus.annotation.FieldFill
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableLogic
import java.time.LocalDateTime

/**
 * 用户token
 * id、userId、token、过期时间、创建时间、更新时间、删除标记
 */
data class UserToken (
    @TableId(type = IdType.AUTO)
    var id: Int? = null,
    var userId: Int? = null,
    var token: String? = null,
    var expireTime: LocalDateTime? = null,
    @TableField(fill = FieldFill.INSERT)
    var createTime: LocalDateTime? = null,
    @TableField(fill = FieldFill.INSERT_UPDATE)
    var updateTime: LocalDateTime? = null,
    @TableLogic
    var deleteFlag: Boolean? = null
) {
    constructor(): this(
        id = null,
        userId = null,
        token = null,
        expireTime = null,
        createTime = null,
        updateTime = null,
        deleteFlag = null
    )
}
