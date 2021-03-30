package com.mihey.personapi.controller

import com.mihey.personapi.model.Person
import com.mihey.personapi.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("persons")
class PersonController(val personService: PersonService) {

    @GetMapping
    fun getPersons(): ResponseEntity<List<Person>> {
        return ResponseEntity(personService.getPersons(),HttpStatus.OK)
    }

}