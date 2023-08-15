package com.twaun95.domain.model.entity.movie

import com.twaun95.domain.model.entity.Entity

data class MovieEntity(
    val code: String,
    val name: String,
    val showTime: String,
    val openDate: String,
    val type: String,
    val genre: String
) : Entity {
    companion object {
        fun empty() : MovieEntity {
            return MovieEntity(
                code = "",
                name = "",
                showTime = "",
                openDate = "",
                type = "",
                genre = ""
            )
        }
    }
}
