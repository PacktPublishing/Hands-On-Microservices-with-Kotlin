package com.microservices.chapter07

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class Chapter07Application

@RestController
class GreetingsController {
  @GetMapping("/greetings")
  fun greetings() = "hello from a docker"
}

fun main(args: Array<String>) {
  runApplication<Chapter07Application>(*args)
}
