package com.microservices.chapter09

import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class CustomerServiceImpl : CustomerService {

  companion object {
    private val initialCustomers = arrayOf(Customer(1, "Kotlin"),
        Customer(2, "Spring"),
        Customer(3, "Microservice")
    )
    private val customers = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy(Customer::id))
  }

  override fun getCustomer(id: Int) = customers[id]
  override fun getAllCustomers() = customers.map(Map.Entry<Int, Customer>::value).toList()
}