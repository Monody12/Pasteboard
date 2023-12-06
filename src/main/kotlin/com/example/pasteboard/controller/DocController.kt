package com.example.pasteboard.controller

import com.example.pasteboard.entity.ApiResponse
import com.example.pasteboard.entity.Doc
import com.example.pasteboard.service.IDocService
import com.example.pasteboard.vo.DocOutline
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/doc")
class DocController {

    @Autowired
    private lateinit var docService: IDocService

    @RequestMapping("/outline")
    fun getDocOutlineList(@RequestHeader("Uid") userId: Int): ApiResponse<List<DocOutline>> {
        val list = docService.getDocOutlineList(userId)
        return ApiResponse.success(data = list)
    }

    @GetMapping
    fun getDoc(@RequestHeader("Uid") userId: Int, @RequestParam id: Int): ApiResponse<out Any?> {
        val doc = docService.getDocByIdAndUserId(id, userId)
            ?: return ApiResponse.notFound("文档不存在")
        return ApiResponse.success(data = doc)
    }

    @PostMapping
    fun newDoc(@RequestHeader("Uid") userId: Int, @RequestBody docOutline: DocOutline): ApiResponse<Doc> {
        val newDoc = docService.newDoc(userId, docOutline.title)
        return ApiResponse.success(data = newDoc)
    }

    @PutMapping
    fun updateDoc(@RequestHeader("Uid") userId: Int, @RequestBody doc: Doc): ApiResponse<out Any?> {
        doc.userId = userId
        val updateDoc = docService.updateDoc(doc)
        return if (updateDoc == 0) {
            ApiResponse.notFound("文档不存在")
        } else {
            ApiResponse.success(data = doc)
        }
    }

    @DeleteMapping
    fun deleteDoc(@RequestParam id: Int, @RequestHeader("Uid") userId: Int): ApiResponse<out Any?> {
        val deleteDoc = docService.deleteDoc(id, userId)
        if (deleteDoc == 0) {
            return ApiResponse.notFound("文档不存在")
        }
        return ApiResponse.success()
    }


}
