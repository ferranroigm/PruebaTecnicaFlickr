package com.example.pruebatecnicaflickr.Network

import com.example.pruebatecnicaflickr.Models.SearchResult
import com.example.pruebatecnicaflickr.Models.WrapperPhoto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EndPoint {

    @GET("/services/rest/")
    fun getResultImages(@Query("method") method: String?, @Query(
        "api_key"
    ) apiKey: String?, @Query("tags") tags: String?, @Query(
        "per_page"
    ) perPage: String?, @Query("format") format: String?,
                        @Query("nojsoncallback") nojsoncallback: String?): Call<SearchResult>

    @GET("/services/rest/")
    fun getInfoImage(@Query("method") method: String?, @Query("api_key") apiKey: String?,
                     @Query("photo_id") photo_id: String?,
                     @Query("format") format: String?,
                     @Query("nojsoncallback") nojsoncallback: String?): Call<WrapperPhoto>

    /*fun getPhotos(
        @Query("method") method: String?, @Query(
            "api_key"
        ) apiKey: String?, @Query("tags") tags: String?, @Query(
            "per_page"
        ) perPage: String?, @Query("format") format: String?, data: Callback<DataImages>
    )*/


}