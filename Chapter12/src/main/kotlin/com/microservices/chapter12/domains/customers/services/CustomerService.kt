package com.microservices.chapter12.domains.customers.services

import com.microservices.chapter12.domains.customers.model.Customer

interface CustomerService {
  fun getCustomer(id: Int): Customer
}