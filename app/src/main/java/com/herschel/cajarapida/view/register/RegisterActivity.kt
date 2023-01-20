package com.herschel.cajarapida.view.register

import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.cajarapida.databinding.ActivityHomeBinding
import com.example.cajarapida.databinding.ActivityRegistroBinding
import com.herschel.cajarapida.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroBinding
    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var awesomeValidation: AwesomeValidation? = null
        awesomeValidation = AwesomeValidation(ValidationStyle.BASIC)

        binding.rRegistro.setOnClickListener{
            val nombre = binding.rNombre.text.toString()
            val apellido = binding.rApellido.text.toString()
            val correo = binding.rCorreo.text.toString()
            val password = binding.rPassword.text.toString()

            awesomeValidation.addValidation(binding.rCorreo, Patterns.EMAIL_ADDRESS,"Ingresa un correo valido")
            awesomeValidation.addValidation(binding.rPassword,".{6,}","Ingresa una contraseña mayor a 6 digitos")
            awesomeValidation.addValidation(binding.rNombre,".{3,}","Por favor llena este campo")
            awesomeValidation.addValidation(binding.rApellido,".{3,}","Por favor llena este campo")

            if (awesomeValidation.validate()){
                registerViewModel.registrarUsuario(nombre,apellido,correo,password,this)
            }else{
                Toast.makeText(this,"Por favor revisa tus datos",Toast.LENGTH_SHORT).show()
            }


        }

    }
}