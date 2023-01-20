package com.herschel.cajarapida.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herschel.cajarapida.model.login.LoginModel
import com.herschel.cajarapida.model.login.LoginProvider

class LoginViewModel: ViewModel() {
    val loginModel = MutableLiveData<LoginModel>()
    fun iniciarSesion(correo: String,password: String, context: Context):LoginModel{
        val currentLogin: LoginModel = LoginProvider.iniciarSesion(correo,password,context)
        loginModel.postValue(currentLogin)
        return currentLogin
    }
}