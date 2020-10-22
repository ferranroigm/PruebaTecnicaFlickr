package com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaAdapter

import com.example.pruebatecnicaflickr.Network.Requests

class BusquedaAdapterPresenter(var mView: BusquedaAdapterContract.View): BusquedaAdapterContract.Presenter {

    init{
        mView.setPresenter(this)
    }

    override fun start() {

    }




}