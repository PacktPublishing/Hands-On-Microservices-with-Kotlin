package com.microservices.chapter12.domains.accounts.services

import com.microservices.chapter12.domains.accounts.model.Account

interface AccountService {
  fun getAccountsByCustomer(customerId: Int): List<Account>
}