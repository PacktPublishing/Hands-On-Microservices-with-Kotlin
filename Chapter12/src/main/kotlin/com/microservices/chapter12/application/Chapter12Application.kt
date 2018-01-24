package com.microservices.chapter12.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Chapter12Application

fun lower(name: String): String {
  val lower = name.toLowerCase()
  return "$name in lower case is: $lower"
}

fun foo() = 14

fun bar() = foo()


fun oddOrEven(number: Int) =
    if (number % 2 == 0)
      "odd"
    else
      "even"

fun fizzBuzz(number: Int) =
    when {
      number % 15 == 0 -> "FizzBuzz"
      number % 3 == 0 -> "Fizz"
      number % 5 == 0 -> "Buzz"
      else -> number.toString()
    }

fun calculate(number1: Int, number2: Int) =
    try {
      number1 / number2
    } catch (ex: Exception) {
      0
    }

fun compute(number1: Int, number2: Int = 2, number3: Int = 5) = number1 * number2 * number3

fun printNumbers() {
  (1..10).forEach(::println)
}

fun main(args: Array<String>) {
  println(lower("Hello"))
  println(bar())
  println(oddOrEven(25))
  println(oddOrEven(36))
  println(fizzBuzz(30))
  println(fizzBuzz(12))
  println(fizzBuzz(10))
  println(fizzBuzz(7))
  println(calculate(10, 2))
  println(calculate(5, 0))
  println(compute(7))
  println(compute(7, 2))
  println(compute(7, 2, 8))
  println(compute(number1 = 8, number3 = 4))
  printNumbers()

  runApplication<Chapter12Application>(*args)
}
