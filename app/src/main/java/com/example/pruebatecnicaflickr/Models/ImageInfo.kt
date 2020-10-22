package com.example.pruebatecnicaflickr.Models

import com.google.gson.annotations.SerializedName

class ImageInfo(
    @SerializedName("id") val id: String,
    //val author: String,
    @SerializedName("title")val title: String){

}