package com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaAdapter.DetailPhoto

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.example.pruebatecnicaflickr.MainActivity
import com.example.pruebatecnicaflickr.R
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class DetailPhotoFragment(var mMainActivity: MainActivity): Fragment(), DetailPhotoContract.View {

    var mPresenter:  DetailPhotoContract.Presenter? = null

    lateinit var mImageViewPhtotoDetail: ImageView
    lateinit var mTextViewTitleDetail: TextView
    lateinit var mTextViewImageAuthorDetail: TextView
    lateinit var mTextViewImageDateDetail: TextView
    lateinit var mTextViewImageDescriptionDetail: TextView
    lateinit var mButtonShareImageDetail: Button

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
        mButtonShareImageDetail = view.findViewById(R.id.buttonShareImage)

        mPresenter!!.start()

        mButtonShareImageDetail.setOnClickListener{

            val sharingIntent = Intent(Intent.ACTION_SEND)
            val uri: Uri? = getLocalBitmapUri(mImageViewPhtotoDetail)
            sharingIntent.type =  "image/jpeg"
            sharingIntent.putExtra(Intent.EXTRA_STREAM,  uri)
            startActivity(Intent.createChooser(sharingIntent, "Compartir imagen"))

        }

    }

    private fun getLocalBitmapUri(imgView: ImageView): Uri? {
        val drawable = imgView.drawable
        val bmp: Bitmap
        if (drawable is BitmapDrawable){
            bmp = (imgView.getDrawable() as BitmapDrawable).bitmap
        }else{
            return null
        }
        var bmpUri: Uri? = null
        try {
            val file = File(
                mMainActivity.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                "share_image_" + System.currentTimeMillis() + ".png"
            )
            val out = FileOutputStream(file)
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out)
            out.close()

            if (android.os.Build.VERSION.SDK_INT >= 24){
                bmpUri = FileProvider.getUriForFile(mMainActivity, "com.codepath.fileprovider", file);

            }else{
                bmpUri = Uri.fromFile(file)
            }


        } catch (e: IOException) {
            e.printStackTrace()
        }

        return bmpUri

    }

    override fun setData() {
        mPresenter!!.loadURLImage(this,mPresenter!!.getUrlPhotoDetail(),mImageViewPhtotoDetail)
        mTextViewTitleDetail.text = mPresenter!!.getTitleDetail()
        mTextViewImageAuthorDetail.text = mPresenter!!.getAuthorDetail()
        mTextViewImageDateDetail.text = mPresenter!!.getDateDetail()
        mTextViewImageDescriptionDetail.text = mPresenter!!.getDescriptionDetail()
    }



}