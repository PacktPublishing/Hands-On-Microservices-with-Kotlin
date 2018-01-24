package com.microservices.chapter09

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {
  @Autowired
  lateinit var customerService: CustomerService

  @GetMapping("/customer/{id}")
  fun getCustomer(@PathVariable id: Int) = customerService.getCustomer(id)

  @GetMapping("/customers")
  fun getCustomers() = customerService.getAllCustomers()
}
