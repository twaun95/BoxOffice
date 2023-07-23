package com.twaun95.domain.model.entity.movie

import com.twaun95.domain.model.entity.Entity

data class BoxOfficeEntity(
    val code: String,
    val name: String,
    val rank: String,
    val openDate: String
) : Entity
