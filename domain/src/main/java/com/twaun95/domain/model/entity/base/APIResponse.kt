package com.twaun95.domain.model.entity.base

data class APIResponse<T>(
    val data: T?,
    val message: String,
    val statusCode: Int
) {
    val isSuccess: Boolean
        get() = statusCode in 200..209
}