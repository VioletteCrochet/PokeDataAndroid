package com.example.demoandroid.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoandroid.helpers.AppDialogHelpers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    var registerData = MutableStateFlow(RegisterDTO())

    fun callRegisterApi(onSuccess : () -> Unit = {}){
        AppDialogHelpers.get().showDialog("Inscription en cours");

        viewModelScope.launch {

            val apiResponse = LoginService.LoginApi.loginService.register(registerData.value);

            AppDialogHelpers.get().closeDialog()

            if (apiResponse.code.equals("200")){

                // Afficher le message popup succés
                // TODO : Pour le moment la popup = message console
                println(apiResponse.message)

                onSuccess()
            }
            else {
                // Afficher le message popup erreur
                // TODO : Pour le moment la popup = message console
                println(apiResponse.message)
            }
        }
    }
}