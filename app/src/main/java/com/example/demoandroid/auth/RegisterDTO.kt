package com.example.demoandroid.auth

data class RegisterDTO(var email : String= "",
                       var pseudo : String= "",
                       var password : String= "",
                       var passwordConfirm : String = "",
                       var cityCode: String= "",
                       var city: String= "",
                       var phone : String= ""
) {
}