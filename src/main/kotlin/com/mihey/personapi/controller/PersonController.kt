package com.mihey.personapi.controller

import com.mihey.personapi.model.Person
import com.mihey.personapi.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("persons")
class PersonController(val personService: PersonService) {

    @GetMapping
    fun getPersons(): ResponseEntity<List<Person>> {
        return ResponseEntity(personService.getPersons(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getPersonbyId(@PathVariable id: Int): ResponseEntity<Person> {
        return ResponseEntity(personService.findById(id), HttpStatus.OK)
    }

    @GetMapping("/{name}")
    fun getPersonByname(@PathVariable name: String): ResponseEntity<List<Person>> {
        return ResponseEntity(personService.findByName(name), HttpStatus.OK)
    }

    @GetMapping("/{lastName}")
    fun getPersonbyLastname(@PathVariable lastName: String): ResponseEntity<List<Person>> {
        return ResponseEntity(personService.findByLastName(lastName), HttpStatus.OK)
    }

    @PostMapping
    fun savePerson(@RequestBody person: Person): ResponseEntity<Person> {
        return ResponseEntity(personService.savePerson(person), HttpStatus.OK)
    }

    @PutMapping
    fun updatePerson(@RequestBody person: Person): ResponseEntity<Person> {
        return ResponseEntity(personService.updatePerson(person), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deletePersonById(@PathVariable id: Int): ResponseEntity<String> {
        personService.deleteById(id)
        return ResponseEntity("User successfully deleted", HttpStatus.OK)
    }
}