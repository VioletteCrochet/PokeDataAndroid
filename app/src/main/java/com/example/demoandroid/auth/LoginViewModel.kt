package com.example.demoandroid.auth


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoandroid.helpers.AppDialogHelpers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class LoginViewModel: ViewModel() {
    var email = MutableStateFlow("isaac@gmail.com")
    var password = MutableStateFlow("password")
    //var loginRequestData = MutableStateFlow<LoginDTO>()

    fun callLoginApi(onSuccess : () -> Unit = {}){
        AppDialogHelpers.get().showDialog("Tentive de connexion...");

        viewModelScope.launch {
            // Preparer le DTO à envoyer dans request body
            // Le DTO qui contient : email et password
            val loginRequest = LoginDTO(email.value, password.value);

            // Appel api async
            val responseService = LoginService.LoginApi.loginService.login(loginRequest);

            // Fermer la popup de chargement aprés l'appel de API
            AppDialogHelpers.get().closeDialog()

            // Si connexion ok
           if (responseService.code.equals("200")){
                onSuccess()
           }
           else{
               // Erreur
           }
        }
    }
}