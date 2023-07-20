package com.rsmartin.data.model

import com.google.gson.annotations.SerializedName

data class OompaLoompaDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("first_name")
    val first_name: String,
    @SerializedName("last_name")
    val last_name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("favorite")
    val favorite: FavoriteDTO,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("profession")
    val profession: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("country")
    val country: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("quota")
    val quota: String,
)