package com.rsmartin.domain.datasource

import com.rsmartin.domain.Resource
import com.rsmartin.domain.model.OompaLoompaItem
import com.rsmartin.domain.model.OompaLoompasModel


interface OompaLoompaDataSource {

    suspend fun getOompaLoompas(page: Int): Resource<OompaLoompasModel>

    suspend fun getOompaLoompa(heroId: Int): Resource<OompaLoompaItem>
}