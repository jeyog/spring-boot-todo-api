package com.jeyog.springboottodoapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class SpringBootTodoApiApplication

fun main(args: Array<String>) {
	runApplication<SpringBootTodoApiApplication>(*args)
}