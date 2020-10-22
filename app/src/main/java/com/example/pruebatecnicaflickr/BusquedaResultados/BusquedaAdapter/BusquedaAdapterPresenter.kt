package com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaAdapter

class BusquedaAdapterPresenter(var mView: BusquedaAdapterContract.View): BusquedaAdapterContract.Presenter {

    init{
        mView.setPresenter(this)
    }

    override fun start() {

    }


}