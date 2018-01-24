package com.microservices.chapter12.domains.customers.model

import com.microservices.chapter12.domains.accounts.model.Account

data class Customer(val id : Int, val name : String, val accounts: List<Account>)
