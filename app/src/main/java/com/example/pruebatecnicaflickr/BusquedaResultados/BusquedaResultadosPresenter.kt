package com.example.pruebatecnicaflickr.BusquedaResultados

import com.example.pruebatecnicaflickr.Network.Requests

class BusquedaResultadosPresenter(var mView: BusquedaResultadosContract.View): BusquedaResultadosContract.Presenter {

    init {
        mView.setPresenter(this)
    }

    override fun start() {

    }

    override fun callAPISearch() {
        //TODO: tag
        Requests.getListDataImage(this,"cat")
    }

    override fun dataChanged() {

    }
}