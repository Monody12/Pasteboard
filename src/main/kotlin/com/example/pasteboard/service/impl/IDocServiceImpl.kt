package com.example.pasteboard.service.impl

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.pasteboard.entity.Doc
import com.example.pasteboard.mapper.DocMapper
import com.example.pasteboard.service.IDocService
import com.example.pasteboard.vo.DocOutline
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class IDocServiceImpl : ServiceImpl<DocMapper, Doc>(), IDocService {
    @Autowired
    private lateinit var docMapper: DocMapper

    override fun getDocOutlineList(userId: Int): List<DocOutline> {
        return docMapper.getDocOutlineList(userId)
    }

    override fun newDoc(userId: Int, title: String): Doc {
        val doc = Doc().apply {
            this.userId = userId
            this.title = title
        }
        docMapper.insert(doc)
        return doc
    }

    override fun updateDoc(doc: Doc) {
        docMapper.updateById(doc)
    }

    override fun deleteDoc(docId: Int, userId: Int) : Int {
        val queryWrapper = LambdaQueryWrapper<Doc>().eq(Doc::id, docId).eq(Doc::userId, userId)
        return docMapper.delete(queryWrapper)
    }
}
