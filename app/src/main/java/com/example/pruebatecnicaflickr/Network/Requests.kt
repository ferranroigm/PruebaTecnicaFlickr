package com.example.pruebatecnicaflickr.Network

import android.util.Log
import android.widget.Toast
import com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaResultadosContract
import com.example.pruebatecnicaflickr.Models.DataImages
import com.example.pruebatecnicaflickr.Models.ImageResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Requests {

    var METHOD_SEARCH = "flickr.photos.search"
    var API_KEY = "1f844315ed6f27e94aaa39771f341200"
    var PER_PAGE = "10"
    var FORMAT = "json"
    var NOJSONCALLBACK = "1"


    fun getListDataImage(presenter: BusquedaResultadosContract.Presenter, tag: String){
        val request = ServiceBuilder.buildService(EndPoint::class.java)
        val call = request.getInfoImages(METHOD_SEARCH, API_KEY, tag, PER_PAGE, FORMAT,NOJSONCALLBACK)
        val a = call.request().url.toString()

        call.enqueue(object : Callback<ImageResult>{
            override fun onResponse(call: Call<ImageResult>, response: Response<ImageResult>) {
                if (response.isSuccessful){
                        presenter.dataChanged()
                    }
                }
            override fun onFailure(call: Call<ImageResult>, t: Throwable) {
                Log.i("getListDataImage", t.message)
            }

        })
    }

}