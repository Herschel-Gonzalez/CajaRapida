package com.herschel.cajarapida.view.home

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.cajarapida.databinding.ActivityHomeBinding
import com.example.cajarapida.databinding.ActivityMainBinding
import com.herschel.cajarapida.viewmodel.LoginViewModel

class HomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHomeBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }




}