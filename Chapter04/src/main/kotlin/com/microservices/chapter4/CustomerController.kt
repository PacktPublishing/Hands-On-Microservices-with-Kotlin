package com.microservices.chapter4

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
class CustomerController {
  @Autowired
  private lateinit var customerService: CustomerService

  @GetMapping(value = "/customer/{id}")
  fun getCustomer(@PathVariable id: Int) =
      ResponseEntity(customerService.getCustomer(id), HttpStatus.OK)

  @GetMapping(value = "/customers")
  fun getCustomers(@RequestParam(required = false, defaultValue = "") nameFilter: String) =
      ResponseEntity(customerService.searchCustomers(nameFilter), HttpStatus.OK)

  @PostMapping(value = "/customer/")
  fun createCustomer(@RequestBody customerMono: Mono<Customer>) =
      ResponseEntity(customerService.createCustomer(customerMono), HttpStatus.CREATED)
}
