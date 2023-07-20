package com.rsmartin.data.model

import com.google.gson.annotations.SerializedName

data class OompaLoompasDTO(
    @SerializedName("current")
    val current: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("results")
    val results: List<OompaLoompaDTO>
)