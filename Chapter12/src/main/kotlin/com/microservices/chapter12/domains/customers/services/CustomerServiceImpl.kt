package com.microservices.chapter12.domains.customers.services

import com.microservices.chapter12.domains.accounts.services.AccountService
import com.microservices.chapter12.domains.customers.model.Customer
import com.microservices.chapter12.domains.customers.services.CustomerService


class CustomerServiceImpl(val accountService: AccountService) : CustomerService {
  override fun getCustomer(id: Int): Customer {
    val accounts = accountService.getAccountsByCustomer(id)
    return Customer(id, "customer$id", accounts)
  }
}
