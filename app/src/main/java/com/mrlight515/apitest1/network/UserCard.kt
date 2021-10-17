package com.mrlight515.apitest1.network

import com.squareup.moshi.Json

data class UserCard(
    @Json(name = "name") val userName: String,
    @Json(name = "birthday") val userBirthDay: String,
    @Json(name = "photo") val userPhoto: String
)