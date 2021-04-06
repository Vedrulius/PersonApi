package com.mihey.personapi.service

import com.mihey.personapi.model.Person

interface PersonService {

    fun getPersons(): List<Person>
    fun findById(id: Int): Person?
    fun findByName(name: String): List<Person>
    fun findByLastName(lastName: String): List<Person>
    fun savePerson(person: Person)
    fun updatePerson(person: Person)
    fun deleteById(id: Int)
}