package com.microservices.chapter06configserver


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class Chapter06ConfigServerApplication

fun main(args: Array<String>) {
  runApplication<Chapter06ConfigServerApplication>(*args)
}
