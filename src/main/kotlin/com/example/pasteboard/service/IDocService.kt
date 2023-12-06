package com.example.pasteboard.service

import com.baomidou.mybatisplus.extension.service.IService
import com.example.pasteboard.entity.Doc
import com.example.pasteboard.vo.DocOutline

interface IDocService : IService<Doc>{
    fun getDocOutlineList(userId: Int): List<DocOutline>
    fun getDocByIdAndUserId(docId: Int, userId: Int): Doc?
    fun newDoc(userId: Int, title: String): Doc
    fun updateDoc(doc: Doc) : Int
    fun deleteDoc(docId: Int, userId: Int) : Int
}
