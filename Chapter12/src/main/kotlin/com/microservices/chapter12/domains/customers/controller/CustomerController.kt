package com.microservices.chapter12.domains.customers.controller

import com.microservices.chapter12.domains.customers.services.CustomerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(val customerService: CustomerService) {
  @GetMapping("/customer/{id}")
  fun getCustomer(@PathVariable id: Int) = customerService.getCustomer(1)
}
