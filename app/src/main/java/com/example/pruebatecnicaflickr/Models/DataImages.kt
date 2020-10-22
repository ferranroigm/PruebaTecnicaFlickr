package com.example.pruebatecnicaflickr.Models

class DataImages {

    data class Image (
        val listImage: List<ImageInfo>
    )

    data class ImageInfo (
        val id: Int,
        val author: String,
        val title: String
    )
}