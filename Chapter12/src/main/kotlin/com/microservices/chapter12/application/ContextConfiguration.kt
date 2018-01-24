package com.microservices.chapter12.application

import com.microservices.chapter12.domains.accounts.services.AccountService
import com.microservices.chapter12.domains.accounts.services.AccountServiceImpl
import com.microservices.chapter12.domains.customers.controller.CustomerController
import com.microservices.chapter12.domains.customers.services.CustomerService
import com.microservices.chapter12.domains.customers.services.CustomerServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ContextConfiguration {
  @Bean
  fun accountService() : AccountService = AccountServiceImpl()

  @Bean
  fun customerService(accountService: AccountService) : CustomerService = CustomerServiceImpl(accountService)

  @Bean
  fun customerController(customerService: CustomerService) = CustomerController(customerService)
}
