package com.herschel.cajarapida.view.login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.cajarapida.databinding.ActivityMainBinding
import com.herschel.cajarapida.model.login.LoginModel
import com.herschel.cajarapida.view.home.HomeActivity
import com.herschel.cajarapida.view.register.RegisterActivity
import com.herschel.cajarapida.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private val loginViewModel : LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var awesomeValidation: AwesomeValidation? = null
        awesomeValidation = AwesomeValidation(ValidationStyle.BASIC)


        binding.login.setOnClickListener(View.OnClickListener {
            val correo = binding.correo.text.toString()
            val password = binding.password.text.toString()

            awesomeValidation.addValidation(binding.correo,Patterns.EMAIL_ADDRESS,"Ingresa un correo valido")
            awesomeValidation.addValidation(binding.password,".{6,}","Ingresa una contraseña mayor a 6 digitos")

            if (awesomeValidation.validate()){
                loginViewModel.iniciarSesion(correo,password,this)
            }else{
                Toast.makeText(this,"Por favor rellena todos los campos",Toast.LENGTH_SHORT).show()
            }
        })

        binding.registro.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }




}