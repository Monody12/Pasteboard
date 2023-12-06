package com.example.pasteboard.entity

data class ApiResponse<T>(
    val code: Int,
    val message: String,
    val data: T
) {
    companion object {
        fun <T> success(data: T): ApiResponse<T> {
            return ApiResponse(200, "成功", data)
        }

        fun success(): ApiResponse<Nothing?> {
            return ApiResponse(200, "成功", null)
        }

        fun success(msg: String): ApiResponse<Nothing?> {
            return ApiResponse(200, msg, null)
        }

        /**
         * 用户名或密码错误
         */
        fun loginError(msg: String): ApiResponse<Any?> {
            return ApiResponse(400, msg, null)
        }

        fun systemError(msg: String): ApiResponse<Any?> {
            return ApiResponse(500, msg, null)
        }

        fun paramError(msg: String): ApiResponse<Any?> {
            return ApiResponse(400, msg, null)
        }

        fun unauthorized(msg: String): ApiResponse<Any?> {
            return ApiResponse(401, msg, null)
        }

        fun forbidden(msg: String): ApiResponse<Any?> {
            return ApiResponse(403, msg, null)
        }

        fun notFound(msg: String): ApiResponse<Any?> {
            return ApiResponse(404, msg, null)
        }

    }
}
