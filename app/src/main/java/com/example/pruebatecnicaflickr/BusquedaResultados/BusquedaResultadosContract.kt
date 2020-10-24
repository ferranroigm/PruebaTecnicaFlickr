package com.example.pruebatecnicaflickr.BusquedaResultados

import com.example.pruebatecnicaflickr.BasePresenter
import com.example.pruebatecnicaflickr.BaseView
import com.example.pruebatecnicaflickr.Models.InfoPhoto.InfoResult
import com.example.pruebatecnicaflickr.Models.Search.SearchResult

interface BusquedaResultadosContract {

    interface Presenter: BasePresenter {
        fun callAPISearch(tag: String)
        fun searchQueueDone(data: SearchResult)
        fun updateModel(data: InfoResult)
        fun isResultSearchEmpty(): Boolean
        fun getLastSearch(): ArrayList<InfoResult>
    }

    interface View: BaseView<Presenter> {
        fun updateRecyclerView(data: List<InfoResult>)
        fun checkStateData()

    }
}