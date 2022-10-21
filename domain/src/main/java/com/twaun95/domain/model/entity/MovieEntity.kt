package com.twaun95.domain.model.entity

data class MovieEntity(
    val name: String,
    val showTime: String,
    val openDate: String,
    val type: String,
    val genre: String
) {
    companion object {
        fun empty() : MovieEntity{
            return MovieEntity(
                name = "",
                showTime = "",
                openDate = "",
                type = "",
                genre = ""
            )
        }
    }
}
