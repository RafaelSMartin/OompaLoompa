package com.rsmartin.domain.usecase

import com.rsmartin.domain.datasource.OompaLoompaDataSource

class GetOompaLoompas(
    private val oompaLoompaDataSource: OompaLoompaDataSource
) {
    suspend fun getOompaLoompas(page: Int) = oompaLoompaDataSource.getOompaLoompas(page)
}