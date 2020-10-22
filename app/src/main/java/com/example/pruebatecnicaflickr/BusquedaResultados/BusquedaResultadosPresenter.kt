package com.example.pruebatecnicaflickr.BusquedaResultados

class BusquedaResultadosPresenter(var mView: BusquedaResultadosContract.View): BusquedaResultadosContract.Presenter {

    init {
        mView.setPresenter(this)
    }

    override fun start() {

    }
}