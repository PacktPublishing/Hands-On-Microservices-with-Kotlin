package com.microservices.chapter4

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.router


@Component
class CustomerRouter(private val customerHandler: CustomerHandler) {
  @Bean
  fun customerRoutes() = router {
    "/functional".nest {
      "/customer".nest {
        GET("/{id}", customerHandler::get)
        POST("/", customerHandler::create)
      }
      "/customers".nest {
        GET("/", customerHandler::search)
      }
    }
  }
}
