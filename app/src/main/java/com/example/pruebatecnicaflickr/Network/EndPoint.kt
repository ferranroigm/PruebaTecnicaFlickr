package com.example.pruebatecnicaflickr.Network

import com.example.pruebatecnicaflickr.Models.DataImages
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EndPoint {

    @GET("")
    fun getInfoImages(@Query("api_key") key: String): Call<DataImages>
}