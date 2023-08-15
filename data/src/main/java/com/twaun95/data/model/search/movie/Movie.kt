package com.twaun95.data.model.search.movie

import com.twaun95.domain.model.entity.movie.MovieEntity

data class Movie(
    val companys: List<Company>,
    val directors: List<Director>,
    val genreAlt: String,
    val movieCd: String,
    val movieNm: String,
    val movieNmEn: String,
    val nationAlt: String,
    val openDt: String,
    val prdtStatNm: String,
    val prdtYear: String,
    val repGenreNm: String,
    val repNationNm: String,
    val typeNm: String
) {
    companion object {
        fun toEntity(movie: Movie) : MovieEntity {
            return MovieEntity(
                code = movie.movieCd,
                name = movie.movieNm,
                showTime = movie.openDt,
                openDate = movie.openDt,
                type = movie.typeNm,
                genre = ""
            )
        }
    }
}