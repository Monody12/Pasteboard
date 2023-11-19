package com.example.pasteboard.controller

import com.example.pasteboard.entity.ApiResponse
import com.example.pasteboard.entity.Doc
import com.example.pasteboard.service.IDocService
import com.example.pasteboard.vo.DocOutline
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/doc")
class DocController {

    @Autowired
    private lateinit var docService: IDocService

    @GetMapping("/outline")
    fun getDocOutlineList(@RequestParam userId: Int) : ApiResponse<List<DocOutline>> {
        val list = docService.getDocOutlineList(userId)
        return ApiResponse.ok(data = list)
    }

    @GetMapping
    fun getDoc(@RequestParam docId: Int) : ApiResponse<Doc> {
        val doc = docService.getById(docId)
        return ApiResponse.ok(data = doc)
    }

    @PostMapping
    fun newDoc(@RequestBody docOutline: DocOutline) : ApiResponse<Doc> {
        val newDoc = docService.newDoc(docOutline.userId, docOutline.title)
        return ApiResponse.ok(data = newDoc)
    }

    @PutMapping
    fun updateDoc(@RequestBody doc: Doc) : ApiResponse<Doc> {
        docService.updateDoc(doc)
        return ApiResponse.ok(data = doc)
    }

    @DeleteMapping
    fun deleteDoc(@RequestParam docId: Int, @RequestParam userId: Int) : ApiResponse<Nothing?> {
        val deleteDoc = docService.deleteDoc(docId, userId)
        if (deleteDoc == 0) {
            return ApiResponse.notFound("文档不存在")
        }
        return ApiResponse.ok()
    }


}
