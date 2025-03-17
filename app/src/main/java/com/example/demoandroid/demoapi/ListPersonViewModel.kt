package com.example.demoandroid.demoapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoandroid.demostateful.Person
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ListPersonViewModel: ViewModel() {
    var persons = MutableStateFlow<List<Person>>(mutableListOf())

    /**
     * *Fonction qui recherge la liste des personnes dans le view model
     */
    fun relaodPersons() {
        //simuler une api
//        persons.value = mutableListOf(
//            Person("po", 10),
//            Person("lala",10),
//            Person("Tinky-Winky",10)

        viewModelScope.launch {
            val apiResponse = PersonService.PersonApi.personService.getPersons()

            persons.value = apiResponse;
        }
    }
}