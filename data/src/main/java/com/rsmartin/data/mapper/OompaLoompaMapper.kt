package com.rsmartin.data.mapper

import com.rsmartin.data.model.FavoriteDTO
import com.rsmartin.data.model.OompaLoompaDTO
import com.rsmartin.data.model.OompaLoompasDTO
import com.rsmartin.domain.model.FavoriteModel
import com.rsmartin.domain.model.OompaLoompaItem
import com.rsmartin.domain.model.OompaLoompasModel

fun OompaLoompasDTO.toOompaLoompasModel(): OompaLoompasModel {
    val list: ArrayList<OompaLoompaItem> = ArrayList()
    this.results.forEach {
        list.add(it.toOompaLoompaModel())
    }
    return OompaLoompasModel(
        this.current,
        this.total,
        list
    )
}

fun OompaLoompaDTO.toOompaLoompaModel(): OompaLoompaItem {
    return OompaLoompaItem(
        this.first_name,
        this.last_name,
        this.favorite.toFavoriteModel(),
        this.gender,
        this.image,
        this.profession,
        this.email,
        this.age,
        this.country,
        this.height,
        this.id
    )
}

fun FavoriteDTO.toFavoriteModel(): FavoriteModel {
    return FavoriteModel(
        this.color,
        this.food,
        this.random_string,
        this.song
    )
}