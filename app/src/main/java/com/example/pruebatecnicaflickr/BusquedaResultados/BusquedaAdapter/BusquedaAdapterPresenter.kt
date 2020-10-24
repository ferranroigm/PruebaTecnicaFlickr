package com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaAdapter

import com.bumptech.glide.Glide
import com.example.pruebatecnicaflickr.Models.InfoPhoto.InfoResult

class BusquedaAdapterPresenter(data: List<InfoResult>, mView: BusquedaAdapterContract.View): BusquedaAdapterContract.Presenter {

    private var mModel = BusquedaAdapterModel(data)

    init{
        mView.setPresenter(this)
    }

    override fun getData(): List<InfoResult> {
        return mModel.data
    }

    override fun loadURLImage(holder: BusquedaAdapter.ViewHolder, url: String) {
        Glide.with(holder.itemView.context).load(url).into(holder.image)
    }

    override fun start() {
        //Empty method
    }




}