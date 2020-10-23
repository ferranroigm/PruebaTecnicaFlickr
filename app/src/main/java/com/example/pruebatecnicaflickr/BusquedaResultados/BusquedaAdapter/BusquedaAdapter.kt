package com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaAdapter.DetailPhoto.DetailPhotoFragment
import com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaAdapter.DetailPhoto.DetailPhotoPresenter
import com.example.pruebatecnicaflickr.MainActivity
import com.example.pruebatecnicaflickr.R

class BusquedaAdapter(var mMainActivity: MainActivity): RecyclerView.Adapter<BusquedaAdapter.ViewHolder>(), BusquedaAdapterContract.View {

    var mPresenter: BusquedaAdapterContract.Presenter? = null

    override fun setPresenter(presenter: BusquedaAdapterContract.Presenter) {
        mPresenter = presenter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.unit_busqueda,parent, false))
    }

    override fun getItemCount(): Int {
        return mPresenter!!.getData().size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val unit = mPresenter!!.getData()[position]

        holder.author.text = unit.owner.realname
        holder.title.text = unit.title._content

        mPresenter!!.loadURLImage(holder, unit.url_image)

        holder.container.setOnClickListener {
            val fragment_detail = DetailPhotoFragment()
            DetailPhotoPresenter(fragment_detail,unit)
            openFragment(fragment_detail)
        }

    }

    private fun openFragment(fragment: Fragment) {
        val transaction = mMainActivity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val author: TextView = itemView.findViewById(R.id.autorUnit)
        val title: TextView = itemView.findViewById(R.id.titleUnit)
        val image: ImageView = itemView.findViewById(R.id.imageViewUnit)
        val container: ConstraintLayout = itemView.findViewById(R.id.containerConstraintLayout)

    }


}