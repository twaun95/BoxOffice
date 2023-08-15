package com.twaun95.data.model.search.people

data class PeopleListResult(
    val peopleList: List<People>,
    val source: String,
    val totCnt: Int
)