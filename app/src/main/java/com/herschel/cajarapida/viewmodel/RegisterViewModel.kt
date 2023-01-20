package com.herschel.cajarapida.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herschel.cajarapida.model.login.LoginProvider
import com.herschel.cajarapida.model.register.RegisterModel
import com.herschel.cajarapida.model.register.RegisterProvider

class RegisterViewModel:ViewModel() {
    val registerModel = MutableLiveData<RegisterModel>()
    fun registrarUsuario(nombre:String,apellido:String,correo: String,password: String, context: Context): RegisterModel {
        val currentRegister: RegisterModel = RegisterProvider.registrarUsuario(nombre, apellido, correo, password, context)
        registerModel.postValue(currentRegister)
        return currentRegister
    }
}