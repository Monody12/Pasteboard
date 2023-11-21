package com.example.pasteboard.entity

import com.baomidou.mybatisplus.annotation.*
import java.time.LocalDateTime

// 文档表，中包含字段 主键id自增，用户id，文档标题，文档内容，创建时间，更新时间，是否删除
data class Doc(
    @TableId(type = IdType.AUTO)
    var id: Int? = null,
    var userId: Int? = null,
    var title: String? = null,
    var content: String? = null,
    @TableField(fill = FieldFill.INSERT)
    var createTime: LocalDateTime? = null,
    @TableField(fill = FieldFill.INSERT_UPDATE)
    var updateTime: LocalDateTime? = null,
    @TableLogic
    var deleteFlag: Boolean? = null
) {
    constructor() : this(
        id = null,
        userId = null,
        title = null,
        content = null,
        createTime = null,
        updateTime = null,
        deleteFlag = null
    )
}
