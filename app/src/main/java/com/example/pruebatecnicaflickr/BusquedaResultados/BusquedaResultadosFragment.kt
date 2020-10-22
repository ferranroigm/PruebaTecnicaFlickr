package com.example.pruebatecnicaflickr.BusquedaResultados

import android.content.Context
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
import com.example.pruebatecnicaflickr.R

class BusquedaResultadosFragment : Fragment(), BusquedaResultadosContract.View {

    var mPresenter:  BusquedaResultadosContract.Presenter? = null

    var mContext: Context? = null
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

        setRecyclerView()

    }

     fun setRecyclerView(){
         val adapter = BusquedaAdapter()
         mRecyclerView.layoutManager = LinearLayoutManager(mContext!!)
         BusquedaAdapterPresenter(adapter)
         mRecyclerView.adapter = adapter
    }

    companion object {
        fun newInstance(): BusquedaResultadosFragment = BusquedaResultadosFragment()
    }


}