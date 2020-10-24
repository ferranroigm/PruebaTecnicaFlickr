package com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaAdapter.DetailPhoto

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.pruebatecnicaflickr.Models.InfoResult

class DetailPhotoPresenter(var mView: DetailPhotoContract.View,
                           unit_data: InfoResult): DetailPhotoContract.Presenter {

    private var mModel = DetailPhotoModel(unit_data)

    init {
        mView.setPresenter(this)
    }

    override fun start() {
        mView.setData()
    }

    override fun getTitleDetail(): String {
        return mModel.unit_data.title._content
    }

    override fun getAuthorDetail(): String  {
        return mModel.unit_data.owner.realname
    }

    override fun getDateDetail(): String  {
        return mModel.unit_data.dates.taken
    }

    override fun getUrlPhotoDetail(): String {
        return mModel.unit_data.url_image
    }

    override fun getDescriptionDetail(): String {
        return mModel.unit_data.description._content
    }

    override fun loadURLImage(view: DetailPhotoFragment, url: String, imageView: ImageView) {
        Glide.with(view).load(url).into(imageView)
    }

}