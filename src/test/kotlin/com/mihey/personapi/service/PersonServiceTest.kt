package com.mihey.personapi.service

import com.mihey.personapi.dao.PersonDao
import com.mihey.personapi.model.Person
import com.mihey.personapi.service.impl.PersonServiceImplementation
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.justRun
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@ExtendWith(MockKExtension::class)
class PersonServiceTest {

    @MockK
    lateinit var personDao: PersonDao

    @InjectMockKs
    lateinit var personServiceUnderTest: PersonServiceImplementation
    val person = Person(1, "Ivan", "Ivanov")

    @Test
    fun findByIdTest() {
        every { personDao.findById(1) } returns person
        val personTest = personServiceUnderTest.findById(1)
        verify { personDao.findById(1) }
        Assertions.assertEquals(person, personTest)
        Assertions.assertNotEquals(Person(1, "Ivan", "Petrov"), personTest)
    }

    @Test
    fun findByNameTest() {
        every { personDao.findByName("Ivan") } returns listOf(person)
        val personsTest = personServiceUnderTest.findByName("Ivan")
        verify { personDao.findByName("Ivan") }
        Assertions.assertEquals(listOf(person), personsTest)
        Assertions.assertNotEquals(listOf(Person(1, "Petr", "Ivanov")), personsTest)
    }

    @Test
    fun findByLastNameTest() {
        every { personDao.findByLastName("Ivanov") } returns listOf(person)
        val personsTest = personServiceUnderTest.findByLastName("Ivanov")
        verify { personDao.findByLastName("Ivanov") }
        Assertions.assertEquals(listOf(person), personsTest)
        Assertions.assertNotEquals(listOf(Person(1, "Ivan", "Sidorov")), personsTest)
    }

    @Test
    fun saveTest() {
        justRun { personDao.savePerson(person) }
        personServiceUnderTest.savePerson(person)
        verify {
            personDao.savePerson(person)
        }
    }

    @Test
    fun getPersonsTest() {
        every { personDao.getPersons() } returns listOf(person)
        val personsTest = personServiceUnderTest.getPersons()
        verify { personDao.getPersons() }
        Assertions.assertEquals(listOf(person), personsTest)
        Assertions.assertNotEquals(listOf(Person(1, "Petr", "Petrov")), personsTest)
    }

    @Test
    fun updatePersonTest() {
        justRun { personDao.updatePerson(person) }
        personServiceUnderTest.updatePerson(person)
        verify {
            personDao.updatePerson(person)
        }
    }

    @Test
    fun deleteByIdTest() {
        justRun { personDao.deleteById(any()) }
        personServiceUnderTest.deleteById(1)
        personServiceUnderTest.deleteById(2)
        personServiceUnderTest.deleteById(3)
        verify {
            personDao.deleteById(1)
            personDao.deleteById(2)
            personDao.deleteById(3)
        }
    }

}