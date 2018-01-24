package com.microservices.chapter4

class CustomerExistException(override val message: String) : Exception(message)
