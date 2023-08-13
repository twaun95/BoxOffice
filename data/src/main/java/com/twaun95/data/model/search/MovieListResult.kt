package com.twaun95.data.model.search

data class MovieListResult(
    val movieList: List<Movie>,
    val source: String,
    val totCnt: Int
)