package com.example.pasteboard.interceptor

import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.web.servlet.HandlerInterceptor
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class TraceIdInterceptor : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        // Generate a unique traceId
        val traceId = UUID.randomUUID().toString()

        // Set traceId to MDC
        MDC.put(TRACE_ID_KEY, traceId)

        // Set traceId to response header
        response.setHeader(TRACE_ID_KEY, traceId)

        logger.info("Incoming request with traceId: {}", traceId)
        return true
    }

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        // Remove traceId from MDC after request processing is completed
        MDC.remove(TRACE_ID_KEY)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(TraceIdInterceptor::class.java)
        private const val TRACE_ID_KEY = "traceId"
    }
}

