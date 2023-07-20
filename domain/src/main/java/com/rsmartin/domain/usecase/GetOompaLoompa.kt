package com.rsmartin.domain.usecase

import com.rsmartin.domain.datasource.OompaLoompaDataSource

class GetOompaLoompa(
    private val oompaLoompaDataSource: OompaLoompaDataSource
) {
    suspend fun getOompaLoompa(oompaLoompaId: Int) = oompaLoompaDataSource.getOompaLoompa(oompaLoompaId)
}