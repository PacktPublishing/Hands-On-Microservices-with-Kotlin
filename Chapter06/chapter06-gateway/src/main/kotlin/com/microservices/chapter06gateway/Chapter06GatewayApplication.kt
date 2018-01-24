package com.microservices.chapter06gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@SpringBootApplication
@EnableZuulProxy
class Chapter06GatewayApplication

fun main(args: Array<String>) {
  runApplication<Chapter06GatewayApplication>(*args)
}
