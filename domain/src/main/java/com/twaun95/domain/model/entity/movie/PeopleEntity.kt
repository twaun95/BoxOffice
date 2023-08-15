package com.twaun95.domain.model.entity.movie

data class PeopleEntity(
    val code: String,
    val name: String,
    val role: String,
    val filmoNames: String
) {
    companion object {
        fun empty(): PeopleEntity {
            return PeopleEntity(
                code = "",
                name = "",
                role = "",
                filmoNames = ""
            )
        }
    }
}