package com.microservices.chapter5

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CustomerServiceImpl : CustomerService {
  @Autowired
  lateinit var customerRepository: CustomerRepository

  override fun getCustomer(id: Int) = customerRepository.findById(id)
  override fun createCustomer(customer: Mono<Customer>) = customerRepository.create(customer)
  override fun deleteCustomer(id: Int) = customerRepository.deleteById(id).map { it.deletedCount > 0 }
  override fun searchCustomers(nameFilter: String) = customerRepository.findCustomer(nameFilter)
}
