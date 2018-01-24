package com.microservices.chapter3

import com.fasterxml.jackson.core.JsonParseException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ErrorHandler {
  @ExceptionHandler(JsonParseException::class)
  fun JsonParseExceptionHandler(servletRequest: HttpServletRequest,
                                exception: Exception): ResponseEntity<ErrorResponse> {
    return ResponseEntity(ErrorResponse("JSON Error", exception.message ?: "invalid json"),
        HttpStatus.BAD_REQUEST)
  }

  @ExceptionHandler(CustomerNotFoundException::class)
  fun CustomerNotFoundExceptionHandler(servletRequest: HttpServletRequest,
                                       exception: Exception): ResponseEntity<ErrorResponse> {
    return ResponseEntity(ErrorResponse("Customer Not Found", exception.message!!),
        HttpStatus.NOT_FOUND)
  }
}
