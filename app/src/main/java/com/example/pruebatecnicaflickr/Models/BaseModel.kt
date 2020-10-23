package com.example.pruebatecnicaflickr.Models

object BaseModel {

    var list_result_search: List<SearchInfo> = ArrayList()
    var list_info_images = ArrayList<InfoResult>()

    fun addInfoImage(item: InfoResult){
        list_info_images.add(item)
    }

    fun clearListInfoImages(){
        list_info_images.clear()
    }
}