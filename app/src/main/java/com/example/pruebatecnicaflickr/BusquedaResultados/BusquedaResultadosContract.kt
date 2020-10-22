package com.example.pruebatecnicaflickr.BusquedaResultados

import com.example.pruebatecnicaflickr.BasePresenter
import com.example.pruebatecnicaflickr.BaseView

interface BusquedaResultadosContract {

    interface Presenter: BasePresenter {
        fun callAPISearch()
        fun dataChanged()
    }

    interface View: BaseView<Presenter> {

    }
}