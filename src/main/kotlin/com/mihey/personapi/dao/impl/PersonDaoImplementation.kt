package com.mihey.personapi.dao.impl

import com.mihey.personapi.dao.PersonDao
import com.mihey.personapi.mapper.PersonMapper
import com.mihey.personapi.model.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class PersonDaoImplementation(@Autowired val jdbcTemplate: JdbcTemplate): PersonDao {

    override fun getPersons(): List<Person> {
        val sql="SELECT * FROM persons"
        return jdbcTemplate.query(sql, PersonMapper())
    }

    override fun findById(id: Int): Person {
        TODO("Not yet implemented")
    }

    override fun findByName(name: String): List<Person> {
        TODO("Not yet implemented")
    }

    override fun findByLastName(lastName: String): List<Person> {
        TODO("Not yet implemented")
    }

    override fun savePerson(person: Person): Person {
        TODO("Not yet implemented")
    }

    override fun updatePerson(person: Person): Person {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Int) {
        TODO("Not yet implemented")
    }
}