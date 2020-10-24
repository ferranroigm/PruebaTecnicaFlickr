package com.example.pruebatecnicaflickr.BusquedaResultados

import com.example.pruebatecnicaflickr.Models.BaseModel
import com.example.pruebatecnicaflickr.Models.InfoResult
import com.example.pruebatecnicaflickr.Models.SearchResult
import com.example.pruebatecnicaflickr.Network.Requests

class BusquedaResultadosPresenter(var mView: BusquedaResultadosContract.View): BusquedaResultadosContract.Presenter {

    init {
        mView.setPresenter(this)
    }

    override fun start() {
        mView.checkStateData()
    }

    override fun callAPISearch(tag: String) {
        Requests.getListDataImage(this,tag)
    }

    override fun searchQueueDone(data: SearchResult) {
        BaseModel.list_result_search = data.photos.photo
        BaseModel.clearListInfoImages()
        Requests.getInfoImages(this, data)
    }

    override fun updateModel(data: InfoResult) {
        BaseModel.addInfoImage(data)
        if(BaseModel.list_info_images.size == BaseModel.list_result_search.size){
            mView.updateRecyclerView(BaseModel.list_info_images)
        }
    }

    override fun isResultSearchEmpty(): Boolean {
        return BaseModel.list_info_images.isEmpty()
    }

    override fun getLastSearch(): ArrayList<InfoResult> {
        return BaseModel.list_info_images
    }
}