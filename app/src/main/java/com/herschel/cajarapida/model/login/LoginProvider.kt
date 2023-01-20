package com.herschel.cajarapida.model.login

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.herschel.cajarapida.view.home.HomeActivity
import com.herschel.cajarapida.view.login.LoginActivity

class LoginProvider {

    companion object{
        private lateinit var auth: FirebaseAuth


        fun iniciarSesion(correo: String, password: String, context : Context): LoginModel {




            auth = Firebase.auth

            auth.signInWithEmailAndPassword(correo, password)
                .addOnCompleteListener { task ->

                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        val user = auth.currentUser

                        Toast.makeText(context,"Sesion Iniciada Exitosamente!",Toast.LENGTH_SHORT).show()

                        val intent = Intent(context, HomeActivity::class.java)

                        startActivity(context,intent,null)

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        println("Fallo al iniciar sesion: ${task.exception.toString()}")
                        Toast.makeText(context,"Error al iniciar sesion: revisa tus credenciales",Toast.LENGTH_SHORT).show()

                    }
                }

            return LoginModel(correo,password,true)

        }
    }



}


