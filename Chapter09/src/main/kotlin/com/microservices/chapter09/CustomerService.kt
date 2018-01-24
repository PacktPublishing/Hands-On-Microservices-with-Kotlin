package com.microservices.chapter09

interface CustomerService {
  fun getCustomer(id: Int): Customer?
  fun getAllCustomers(): List<Customer>
}