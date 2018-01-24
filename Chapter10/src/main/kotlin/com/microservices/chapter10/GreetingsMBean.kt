package com.microservices.chapter10

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jmx.export.annotation.ManagedOperation
import org.springframework.jmx.export.annotation.ManagedOperationParameter
import org.springframework.jmx.export.annotation.ManagedOperationParameters
import org.springframework.jmx.export.annotation.ManagedResource
import org.springframework.stereotype.Component

@Component
@ManagedResource(objectName = "com.microservices:type=greetings,name=GetHello",
    description = "Get greetings")
class GreetingsMBean {
  @Autowired
  lateinit var greetingsService: GreetingsService

  @ManagedOperation(description = "Returns a greeting message")
  @ManagedOperationParameters(ManagedOperationParameter(description = "provide a name",
      name = "name"))
  fun hello(name: String) = try {
    greetingsService.getGreeting() + " $name!"
  } catch (exception: Exception) {
    "oh $name, we get an error: $exception"
  }
}
