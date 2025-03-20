package com.example.demoandroid.auth


import com.example.demoandroid.api.ResponseAPI
import com.example.demoandroid.api.RetrofitTools.Companion.retrofit
import retrofit2.http.Body
import retrofit2.http.POST


interface LoginService {
    companion object {
        var token : String = "";
    }

    @POST("login")
    suspend fun login(@Body loginDTO: LoginDTO) : ResponseAPI<String>

    @POST("signup")
    suspend fun register(@Body signUpRequestDTO: RegisterDTO) : ResponseAPI<RegisterDTO>

    @POST("reset-password")
    suspend fun resetPassword(@Body email: EmailDTO) : ResponseAPI<String>


    object LoginApi {
        val loginService : LoginService by lazy { retrofit.create(LoginService::class.java) }
    }
}