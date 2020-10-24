package com.example.pruebatecnicaflickr.Models.Search

import com.google.gson.annotations.SerializedName

class SearchInfo(
    @SerializedName("id") val id: String,
    @SerializedName("title")val title: String,
    @SerializedName("farm")val farm: String,
    @SerializedName("server")val server: String,
    @SerializedName("secret")val secret: String)

{

}