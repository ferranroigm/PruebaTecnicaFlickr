package com.example.pruebatecnicaflickr.BusquedaResultados

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaAdapter.BusquedaAdapter
import com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaAdapter.BusquedaAdapterPresenter
import com.example.pruebatecnicaflickr.MainActivity
import com.example.pruebatecnicaflickr.Models.InfoPhoto.InfoResult
import com.example.pruebatecnicaflickr.R

class BusquedaResultadosFragment(var mMainActivity: MainActivity) : Fragment(), BusquedaResultadosContract.View {

    var mPresenter:  BusquedaResultadosContract.Presenter? = null
    lateinit var mEditTextSearch: EditText
    lateinit var mButtonSearch: Button
    lateinit var mRecyclerView: RecyclerView

    override fun setPresenter(presenter: BusquedaResultadosContract.Presenter) {
        mPresenter = presenter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.busqueda_resultados, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mEditTextSearch = view.findViewById(R.id.editTextSearch)
        mButtonSearch = view.findViewById(R.id.buttonSearch)
        mRecyclerView = view.findViewById(R.id.recyclerViewSearch)

        buttonListener()

    }

    override fun onResume() {
        super.onResume()
        mPresenter!!.start()
    }

    override fun checkStateData(){
        if (!mPresenter!!.isResultSearchEmpty()){
            updateRecyclerView(mPresenter!!.getLastSearch())
        }
    }

    fun buttonListener(){
        mButtonSearch.setOnClickListener {
            val tag = mEditTextSearch.text.toString()
            mPresenter!!.callAPISearch(tag)
        }
    }

    override fun updateRecyclerView(data: List<InfoResult>) {
        val adapter = BusquedaAdapter(mMainActivity)
        mRecyclerView.layoutManager = LinearLayoutManager(mMainActivity.applicationContext)
        BusquedaAdapterPresenter(data, adapter)
        mRecyclerView.adapter = adapter
    }

    companion object {
        fun newInstance(mMainActivity: MainActivity): BusquedaResultadosFragment = BusquedaResultadosFragment(mMainActivity)
    }


}