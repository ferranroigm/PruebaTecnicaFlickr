package com.example.pruebatecnicaflickr.Models.InfoPhoto

import com.google.gson.annotations.SerializedName

class InfoResult(@SerializedName("description") var description: InfoDescription,
                 @SerializedName("id") val id: String,
                 @SerializedName("title")val title: InfoTitle,
                 @SerializedName("farm")val farm: String,
                 @SerializedName("server")val server: String,
                 @SerializedName("secret")val secret: String,
                 @SerializedName("owner")val owner: InfoOwner,
                 @SerializedName("dates")val dates: InfoDates,
                 var url_image: String) {

}