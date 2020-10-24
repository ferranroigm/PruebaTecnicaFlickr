package com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaAdapter

import com.example.pruebatecnicaflickr.BasePresenter
import com.example.pruebatecnicaflickr.BaseView
import com.example.pruebatecnicaflickr.Models.InfoPhoto.InfoResult

interface BusquedaAdapterContract {

    interface Presenter: BasePresenter {
        fun getData(): List<InfoResult>
        fun loadURLImage(holder: BusquedaAdapter.ViewHolder, url: String)
    }

    interface View: BaseView<Presenter> {

    }
}