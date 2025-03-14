package com.example.demoandroid.demomvvm

import androidx.lifecycle.ViewModel
import com.example.demoandroid.demostateful.Person
import kotlinx.coroutines.flow.MutableStateFlow

class DemoViewModel: ViewModel() {
    var persons = MutableStateFlow<List<Person>>(
        mutableListOf(
            Person("Tartine", 26) ,
            Person("BarkingBoy", 28),
            Person("Jujute", 33)
        )
    )
}