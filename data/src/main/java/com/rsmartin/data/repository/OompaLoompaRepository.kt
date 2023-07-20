package com.rsmartin.data.repository

import com.rsmartin.data.api.OompaLoompaApi
import com.rsmartin.data.error.ErrorHandler
import com.rsmartin.data.mapper.toOompaLoompaModel
import com.rsmartin.data.mapper.toOompaLoompasModel
import com.rsmartin.domain.Resource
import com.rsmartin.domain.datasource.OompaLoompaDataSource
import com.rsmartin.domain.model.OompaLoompaItem
import com.rsmartin.domain.model.OompaLoompasModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OompaLoompaRepository(
    private val api: OompaLoompaApi,
    private val errorHandler: ErrorHandler,
) : OompaLoompaDataSource {

    override suspend fun getOompaLoompas(page: Int): Resource<OompaLoompasModel> =
        withContext(Dispatchers.IO) {
            try {
                val response = api.getOompaLoompas(page)

                if (response.isSuccessful) {
                    return@withContext Resource.Success(response.body()!!.toOompaLoompasModel())
                } else {
                    return@withContext Resource.Error(
                        errorHandler(
                            response.code(),
                            response.errorBody()
                        )
                    )
                }
            } catch (e: Exception) {
                return@withContext Resource.Error(errorHandler(e))
            }
        }

    override suspend fun getOompaLoompa(oompaLoompaId: Int): Resource<OompaLoompaItem> =
        withContext(Dispatchers.IO) {
            try {
                val response = api.getOompaLoompa(oompaLoompaId)

                if (response.isSuccessful) {
                    return@withContext Resource.Success(response.body()!!.toOompaLoompaModel())
                } else {
                    return@withContext Resource.Error(
                        errorHandler(
                            response.code(),
                            response.errorBody()
                        )
                    )
                }
            } catch (e: Exception) {
                return@withContext Resource.Error(errorHandler(e))
            }
        }
}

