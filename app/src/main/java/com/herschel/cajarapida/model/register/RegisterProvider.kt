package com.herschel.cajarapida.model.register

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.herschel.cajarapida.model.login.LoginModel
import com.herschel.cajarapida.view.home.HomeActivity

class RegisterProvider {
    companion object{
        private lateinit var auth: FirebaseAuth


        fun registrarUsuario(nombre:String,apellido:String,correo: String, password: String, context : Context): RegisterModel {


            auth = Firebase.auth

            auth.createUserWithEmailAndPassword(correo, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
                        Toast.makeText(context,"Registro exitoso!",Toast.LENGTH_SHORT).show()
                        //iniciamos sesion con los nuevos datos
                        auth.signInWithEmailAndPassword(correo,password).addOnCompleteListener{ tarea ->
                            if (tarea.isSuccessful){
                                //como fue exitoso iniciamos el home
                                var intent = Intent( context,HomeActivity::class.java)
                                startActivity(context,intent,null)
                                Toast.makeText(context,"Sesion iniciada",Toast.LENGTH_SHORT).show()
                            }else{
                                //error al iniciar sesion
                                Toast.makeText(context,"Error al iniciar sesion, intenta nuevamente",Toast.LENGTH_SHORT).show()

                            }
                        }

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(context, "Error al registrar, revisa tus datos.",
                            Toast.LENGTH_SHORT).show()

                    }
                }

            return RegisterModel(nombre, apellido, correo, password)

        }
    }
}