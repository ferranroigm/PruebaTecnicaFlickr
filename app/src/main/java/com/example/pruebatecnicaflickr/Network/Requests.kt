package com.example.pruebatecnicaflickr.Network

import com.example.pruebatecnicaflickr.Models.DataImages
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Requests {

    fun getListDataImage(){
        val request = ServiceBuilder.buildService(EndPoint::class.java)
        val call = request.getInfoImages("api_key")

        call.enqueue(object : Callback<DataImages>{
            override fun onResponse(call: Call<DataImages>, response: Response<DataImages>) {
                if (response.isSuccessful){

                    }
                }
            override fun onFailure(call: Call<DataImages>, t: Throwable) {

            }

        })
    }

}