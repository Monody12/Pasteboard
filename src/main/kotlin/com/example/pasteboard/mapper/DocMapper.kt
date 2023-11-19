package com.example.pasteboard.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.example.pasteboard.entity.Doc
import com.example.pasteboard.vo.DocOutline
import org.apache.ibatis.annotations.Mapper

@Mapper
interface DocMapper : BaseMapper<Doc> {
    fun getDocOutlineList(userId: Int): List<DocOutline>
}
