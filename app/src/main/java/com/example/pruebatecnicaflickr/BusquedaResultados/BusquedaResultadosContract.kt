package com.example.pruebatecnicaflickr.BusquedaResultados

import com.example.pruebatecnicaflickr.BasePresenter
import com.example.pruebatecnicaflickr.BaseView
import com.example.pruebatecnicaflickr.Models.InfoResult
import com.example.pruebatecnicaflickr.Models.SearchResult

interface BusquedaResultadosContract {

    interface Presenter: BasePresenter {
        fun callAPISearch()
        fun searchQueueDone(data: SearchResult)
        fun updateModel(data: InfoResult)
    }

    interface View: BaseView<Presenter> {

        fun updateRecyclerView(data: List<InfoResult>)

    }
}