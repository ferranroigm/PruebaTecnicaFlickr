package com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaAdapter

import com.example.pruebatecnicaflickr.BasePresenter
import com.example.pruebatecnicaflickr.BaseView

interface BusquedaAdapterContract {

    interface Presenter: BasePresenter {

    }

    interface View: BaseView<Presenter> {

    }
}