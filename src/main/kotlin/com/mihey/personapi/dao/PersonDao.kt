package com.mihey.personapi.dao

import com.mihey.personapi.model.Person

interface PersonDao {

    fun getPersons(): List<Person>
    fun findById(id: Int): Person
    fun findByName(id: Int): List<Person>
    fun findByLastName(id: Int): List<Person>
    fun savePerson(id: Int): Person
    fun updatePerson(id: Int): Person
    fun deleteById(id: Int)
}