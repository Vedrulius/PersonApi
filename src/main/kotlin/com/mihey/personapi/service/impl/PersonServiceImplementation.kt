package com.mihey.personapi.service.impl

import com.mihey.personapi.dao.PersonDao
import com.mihey.personapi.model.Person
import com.mihey.personapi.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonServiceImplementation(@Autowired val personDao: PersonDao): PersonService {

    override fun getPersons(): List<Person> {
        return personDao.getPersons();
    }

    override fun findById(id: Int): Person {
        return personDao.findById(id);
    }

    override fun findByName(name: String): List<Person> {
        return  personDao.findByName(name)
    }

    override fun findByLastName(lastName: String): List<Person> {
        return personDao.findByLastName(lastName)
    }

    override fun savePerson(person: Person): Person {
        return personDao.savePerson(person)
    }

    override fun updatePerson(person: Person): Person {
        return personDao.updatePerson(person)
    }

    override fun deleteById(id: Int) {
        personDao.deleteById(id)
    }
}