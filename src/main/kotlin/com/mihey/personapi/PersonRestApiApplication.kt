package com.mihey.personapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PersonRestApiApplication

fun main(args: Array<String>) {
	runApplication<PersonRestApiApplication>(*args)
}
