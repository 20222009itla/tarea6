package com.example.tarea6.data.models

data class RandomUserResponse(
    val results: List<RandomUserItem>? = null
)

data class RandomUserItem(
    val name: RandomUserName? = null,
    val picture: RandomUserPicture? = null,
    val dob: RandomUserDob? = null
)

data class RandomUserName(
    val title: String? = null,
    val first: String? = null,
    val last: String? = null
)

data class RandomUserPicture(
    val large: String? = null,
    val medium: String? = null,
    val thumbnail: String? = null
)

data class RandomUserDob(
    val date: String? = null,
    val age: Int? = null
)
