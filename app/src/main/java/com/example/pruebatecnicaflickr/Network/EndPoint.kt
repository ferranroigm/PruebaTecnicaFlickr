package com.example.pruebatecnicaflickr.Network

import com.example.pruebatecnicaflickr.Models.DataImages
import com.example.pruebatecnicaflickr.Models.ImageResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface EndPoint {

    @GET("/services/rest/")
    fun getInfoImages(@Query("method") method: String?, @Query(
        "api_key"
    ) apiKey: String?, @Query("tags") tags: String?, @Query(
        "per_page"
    ) perPage: String?, @Query("format") format: String?,
                      @Query("nojsoncallback") nojsoncallback: String?): Call<ImageResult>

    /*fun getPhotos(
        @Query("method") method: String?, @Query(
            "api_key"
        ) apiKey: String?, @Query("tags") tags: String?, @Query(
            "per_page"
        ) perPage: String?, @Query("format") format: String?, data: Callback<DataImages>
    )*/
}