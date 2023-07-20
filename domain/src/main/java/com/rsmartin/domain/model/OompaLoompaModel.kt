package com.rsmartin.domain.model


data class OompaLoompasModel(
    val current: Int,
    val total: Int,
    val results: List<OompaLoompaItem>
)

data class OompaLoompaItem(
    val first_name: String,
    val last_name: String,
    val favorite: FavoriteModel,
    val gender: String,
    val image: String,
    val profession: String,
    val email: String,
    val age: Int,
    val country: String,
    val height: Int,
    val id: Int
)

data class FavoriteModel(
    val color : String,
    val food : String,
    val random_string : String,
    val song : String
)
