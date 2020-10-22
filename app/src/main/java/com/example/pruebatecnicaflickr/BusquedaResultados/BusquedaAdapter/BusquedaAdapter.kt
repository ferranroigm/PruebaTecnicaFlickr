package com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatecnicaflickr.R

class BusquedaAdapter: RecyclerView.Adapter<BusquedaAdapter.ViewHolder>(), BusquedaAdapterContract.View {
    
    var mPresenter: BusquedaAdapterContract.Presenter? = null

    override fun setPresenter(presenter: BusquedaAdapterContract.Presenter) {
        mPresenter = presenter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.unit_busqueda,parent, false))
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


    }

    
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


    }



}