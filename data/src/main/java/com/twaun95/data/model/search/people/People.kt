package com.twaun95.data.model.search.people

import com.twaun95.domain.model.entity.movie.PeopleEntity

data class People(
    val filmoNames: String,
    val peopleCd: String,
    val peopleNm: String,
    val peopleNmEn: String,
    val repRoleNm: String
) {
    companion object {
        fun toEntity(people: People): PeopleEntity {
            return PeopleEntity(
                code = people.peopleCd,
                name = people.peopleNm,
                role = people.repRoleNm,
                filmoNames = people.filmoNames
            )
        }
    }
}