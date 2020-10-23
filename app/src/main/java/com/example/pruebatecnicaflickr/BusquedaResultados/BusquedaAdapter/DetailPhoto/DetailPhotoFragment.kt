package com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaAdapter.DetailPhoto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.pruebatecnicaflickr.R

class DetailPhotoFragment: Fragment(), DetailPhotoContract.View {

    var mPresenter:  DetailPhotoContract.Presenter? = null

    lateinit var mImageViewPhtotoDetail: ImageView
    lateinit var mTextViewTitleDetail: TextView
    lateinit var mTextViewImageAuthorDetail: TextView
    lateinit var mTextViewImageDateDetail: TextView
    lateinit var mTextViewImageDescriptionDetail: TextView

    override fun setPresenter(presenter: DetailPhotoContract.Presenter) {
        mPresenter = presenter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.image_info_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mImageViewPhtotoDetail = view.findViewById(R.id.imageViewDetail)
        mTextViewTitleDetail = view.findViewById(R.id.imageTitleDetail)
        mTextViewImageAuthorDetail = view.findViewById(R.id.imageAuthorDetail)
        mTextViewImageDateDetail = view.findViewById(R.id.imageDateDetail)
        mTextViewImageDescriptionDetail = view.findViewById(R.id.descriptionImageDetail)

        mPresenter!!.start()

    }

    override fun setData() {
        mPresenter!!.loadURLImage(this,mPresenter!!.getUrlPhotoDetail(),mImageViewPhtotoDetail)
        mTextViewTitleDetail.text = mPresenter!!.getTitleDetail()
        mTextViewImageAuthorDetail.text = mPresenter!!.getAuthorDetail()
        mTextViewImageDateDetail.text = mPresenter!!.getDateDetail()
        mTextViewImageDescriptionDetail.text = mPresenter!!.getDescriptionDetail()
    }



}