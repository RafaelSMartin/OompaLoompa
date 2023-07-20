package com.rsmartin.data.api

import com.rsmartin.data.model.OompaLoompaDTO
import com.rsmartin.data.model.OompaLoompasDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OompaLoompaApi {

    @GET("napptilus/oompa-loompas")
    suspend fun getOompaLoompas(
        @Query("page") page: Int
    ): Response<OompaLoompasDTO>

    @GET("napptilus/oompa-loompas/{id}")
    suspend fun getOompaLoompa(
        @Path("id") oompaLoompaId: Int
    ): Response<OompaLoompaDTO>
}