package com.example.pasteboard.config

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import org.apache.ibatis.reflection.MetaObject
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class MyBatisMetaObjectHandler : MetaObjectHandler{
    override fun insertFill(metaObject: MetaObject?) {
        val createTime = getFieldValByName("createTime", metaObject)
        val updateTime = getFieldValByName("updateTime", metaObject)
        if (createTime == null) {
            setFieldValByName("createTime", LocalDateTime.now(), metaObject)
        }
        if (updateTime == null) {
            setFieldValByName("updateTime", LocalDateTime.now(), metaObject)
        }
    }

    override fun updateFill(metaObject: MetaObject?) {
        setFieldValByName("updateTime", LocalDateTime.now(), metaObject)
    }
}
