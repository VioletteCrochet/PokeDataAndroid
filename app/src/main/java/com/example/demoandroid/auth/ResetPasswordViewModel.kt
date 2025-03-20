package com.example.demoandroid.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoandroid.helpers.AppDialogHelpers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ResetPasswordViewModel : ViewModel() {

    var email = MutableStateFlow("isaac@gmail.com")

    fun callResetPasswordApi(onSuccess : () -> Unit = {}){
        AppDialogHelpers.get().showDialog("Envoie du mail de réinitialisation");

        viewModelScope.launch {
            // Appel api async
            val emailDTO = EmailDTO(email.value);
            val responseService = LoginService.LoginApi.loginService.resetPassword(emailDTO);

            // Fermer la popup de chargement aprés l'appel de API
            AppDialogHelpers.get().closeDialog()

            onSuccess()

        }
    }
}