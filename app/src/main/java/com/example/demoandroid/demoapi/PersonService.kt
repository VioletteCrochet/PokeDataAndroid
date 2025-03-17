package com.example.demoandroid.demoapi

import com.example.demoandroid.demoapi.RetrofitTools.Companion.retrofit
import com.example.demoandroid.demostateful.Person
import retrofit2.http.GET

interface PersonService {

    @GET("persons.json")
    suspend fun getPersons() : List<Person>

    // Pourra être accessible via cet appel : PersonApi.personService
    object PersonApi {
        val personService : PersonService by lazy { retrofit.create(PersonService::class.java) }
    }

}