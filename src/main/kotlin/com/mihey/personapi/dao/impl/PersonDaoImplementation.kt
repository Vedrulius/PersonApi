package com.mihey.personapi.dao.impl

import com.mihey.personapi.dao.PersonDao
import com.mihey.personapi.mapper.PersonMapper
import com.mihey.personapi.model.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class PersonDaoImplementation(@Autowired val jdbcTemplate: JdbcTemplate) : PersonDao {

    override fun getPersons(): List<Person> {
        val sql = "SELECT * FROM persons"
        return jdbcTemplate.query(sql, PersonMapper())
    }

    override fun findById(id: Int): Person {
        val sql = "SELECT * FROM persons WHERE id=?"
        return jdbcTemplate.queryForObject(sql, PersonMapper(), id) ?: throw RuntimeException("No such person!")
    }

    override fun findByName(name: String): List<Person> {
        val sql = "SELECT * FROM persons WHERE name=?"
        return jdbcTemplate.query(sql, PersonMapper(), name)
    }

    override fun findByLastName(lastName: String): List<Person> {
        val sql = "SELECT * FROM persons WHERE last_name=?"
        return jdbcTemplate.query(sql, PersonMapper(), lastName)
    }

    override fun savePerson(person: Person): Person {
        val sql = "INSERT INTO persons (name,last_name) VALUES (?, ?)"
        jdbcTemplate.update(sql,person.name,person.lastName)
        return person
    }

    override fun updatePerson(person: Person): Person {
        val sql = "UPDATE persons SET name=?, last_name=?  WHERE id=?"
        jdbcTemplate.update(sql,person.name,person.lastName,person.id)
        return person
    }

    override fun deleteById(id: Int) {
        val sql = "DELETE FROM persons WHERE id=?"
        jdbcTemplate.update(sql, id)
    }
}