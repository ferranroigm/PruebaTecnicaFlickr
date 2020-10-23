package com.example.pruebatecnicaflickr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaResultadosFragment
import com.example.pruebatecnicaflickr.BusquedaResultados.BusquedaResultadosPresenter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val busquedaResultadosFragment = BusquedaResultadosFragment.newInstance()
        busquedaResultadosFragment.mContext = this
        busquedaResultadosFragment.mMainActivity = this
        BusquedaResultadosPresenter(busquedaResultadosFragment)
        openFragment(busquedaResultadosFragment)


    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        //transaction.addToBackStack(null)
        transaction.commit()
    }
}
