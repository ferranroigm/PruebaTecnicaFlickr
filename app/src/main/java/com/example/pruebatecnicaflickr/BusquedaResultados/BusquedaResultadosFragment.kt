package com.example.pruebatecnicaflickr.BusquedaResultados

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatecnicaflickr.R

class BusquedaResultadosFragment : Fragment() {

    var mContext: Context? = null
    lateinit var mEditTextSearch: EditText
    lateinit var mButtonSearch: Button
    lateinit var mRecyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.busqueda_resultados, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mEditTextSearch = view.findViewById(R.id.editTextSearch)
        mButtonSearch = view.findViewById(R.id.buttonSearch)
        mRecyclerView = view.findViewById(R.id.recyclerViewSearch)

    }

    companion object {
        fun newInstance(): BusquedaResultadosFragment = BusquedaResultadosFragment()
    }
}