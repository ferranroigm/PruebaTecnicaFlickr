package com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaAdapter.DetailPhoto

import android.widget.ImageView
import com.example.pruebatecnicaflickr.BasePresenter
import com.example.pruebatecnicaflickr.BaseView

interface DetailPhotoContract {

    interface Presenter: BasePresenter {
        fun getTitleDetail(): String
        fun getAuthorDetail(): String
        fun getDateDetail(): String
        fun getUrlPhotoDetail(): String
        fun loadURLImage(view: DetailPhotoFragment, url: String,imageView: ImageView)
        fun getDescriptionDetail(): String

    }

    interface View: BaseView<Presenter> {
        fun setData()
    }
}