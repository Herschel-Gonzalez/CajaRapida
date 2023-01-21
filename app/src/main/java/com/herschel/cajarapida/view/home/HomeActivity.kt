package com.herschel.cajarapida.view.home

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.cajarapida.R
import com.example.cajarapida.databinding.ActivityHomeBinding
import com.example.cajarapida.databinding.ActivityMainBinding
import com.herschel.cajarapida.view.products.ProductsFragment
import com.herschel.cajarapida.view.stadistics.StadisticsFragment
import com.herschel.cajarapida.viewmodel.LoginViewModel

class HomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        reemplazarFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.ventas -> reemplazarFragment(HomeFragment())
                R.id.productos -> reemplazarFragment(ProductsFragment())
                R.id.estadisticas -> reemplazarFragment(StadisticsFragment())

                else ->{

                }


            }
            true
        }

    }


private fun reemplazarFragment(fragment : Fragment){
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.frame_layout,fragment)
    fragmentTransaction.commit()
}

}