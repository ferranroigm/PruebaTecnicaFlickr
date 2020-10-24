package com.example.pruebatecnicaflickr.Network

import android.util.Log
import com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaResultadosContract
import com.example.pruebatecnicaflickr.Models.Search.SearchResult
import com.example.pruebatecnicaflickr.Models.InfoPhoto.WrapperPhoto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Requests {

    var METHOD_SEARCH = "flickr.photos.search"
    var METHOD_INFO = "flickr.photos.getInfo"
    var API_KEY = "1f844315ed6f27e94aaa39771f341200"
    var PER_PAGE = "10"
    var FORMAT = "json"
    var NOJSONCALLBACK = "1"

    var FARM_URL = "http://farm"
    var STATICFLICKR = ".staticflickr.com/"
    var SLASH = "/"
    var SYMBOL = "_"
    var JPG = ".jpg"


    fun getListDataImage(presenter: BusquedaResultadosContract.Presenter, tag: String){
        val request = ServiceBuilder.buildService(EndPoint::class.java)
        val call = request.getResultImages(METHOD_SEARCH, API_KEY, tag, PER_PAGE, FORMAT,NOJSONCALLBACK)
        val a = call.request().url.toString()

        call.enqueue(object : Callback<SearchResult>{
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                if (response.isSuccessful){
                        presenter.searchQueueDone(response.body()!!)
                    }
                }
            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                Log.i("getListDataImage", t.message)
            }

        })
    }

    fun getInfoImages(presenter: BusquedaResultadosContract.Presenter, obj: SearchResult){
        val request = ServiceBuilder.buildService(EndPoint::class.java)

        for (image in obj.photos.photo){
            val call = request.getInfoImage(METHOD_INFO,API_KEY, image.id, FORMAT, NOJSONCALLBACK)
            call.enqueue(object: Callback<WrapperPhoto>{
                override fun onResponse(call: Call<WrapperPhoto>, response: Response<WrapperPhoto>) {
                    if (response.isSuccessful){
                        val imageInfo = response.body()!!.photo
                        val url_image = FARM_URL + imageInfo.farm + STATICFLICKR +
                                imageInfo.server + SLASH + imageInfo.id + SYMBOL + imageInfo.secret + JPG
                        imageInfo.url_image = url_image

                        presenter.updateModel(imageInfo)
                    }
                }

                override fun onFailure(call: Call<WrapperPhoto>, t: Throwable) {
                    Log.i("getInfoImages", t.message)
                }
            })
        }


    }

}