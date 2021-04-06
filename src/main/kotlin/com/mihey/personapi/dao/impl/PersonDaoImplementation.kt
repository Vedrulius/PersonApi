package com.mihey.personapi.dao.impl

import com.mihey.personapi.dao.PersonDao
import com.mihey.personapi.mapper.PersonMapper
import com.mihey.personapi.model.Person
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class PersonDaoImplementation(private val jdbcTemplate: JdbcTemplate) : PersonDao {

    override fun getPersons(): List<Person> {
        val sql = "SELECT * FROM persons"
        return jdbcTemplate.query(sql, PersonMapper())
    }

    override fun findById(id: Int): Person? {
        val sql = "SELECT * FROM persons WHERE id=?"
        return jdbcTemplate.queryForObject(sql, PersonMapper(), id)
    }

    override fun findByName(name: String): List<Person> {
        val sql = "SELECT * FROM persons WHERE name=?"
        return jdbcTemplate.query(sql, PersonMapper(), name)
    }

    override fun findByLastName(lastName: String): List<Person> {
        val sql = "SELECT * FROM persons WHERE last_name=?"
        return jdbcTemplate.query(sql, PersonMapper(), lastName)
    }

    override fun savePerson(person: Person) {
        val sql = "INSERT INTO persons (name,last_name) VALUES (?, ?)"
        jdbcTemplate.update(sql, person.name, person.lastName)
    }

    override fun updatePerson(person: Person) {
        val sql = "UPDATE persons SET name=?, last_name=?  WHERE id=?"
        jdbcTemplate.update(sql, person.name, person.lastName, person.id)
    }

    override fun deleteById(id: Int) {
        val sql = "DELETE FROM persons WHERE id=?"
        jdbcTemplate.update(sql, id)
    }
}