package com.microservices.chapter11

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {
  @Autowired
  lateinit var mockMvc: MockMvc

  @Test
  fun `we should get the customer list`() {
    mockMvc.perform(get("/customers"))
        .andExpect(status().isOk)
        .andExpect(jsonPath("\$[0].id").value(1))
        .andExpect(jsonPath("\$[0].name").value("Kotlin"))
        .andExpect(jsonPath("\$[1].id").value(2))
        .andExpect(jsonPath("\$[1].name").value("Spring"))
        .andExpect(jsonPath("\$[2].id").value(3))
        .andExpect(jsonPath("\$[2].name").value("Microservice"))
        .andExpect(jsonPath("\$[3].id").value(4))
        .andExpect(jsonPath("\$[3].name").value("OpenShift"))
        .andDo(print())
  }

  @Test
  fun `we should get a customer by id`() {
    mockMvc.perform(get("/customer/1"))
        .andExpect(status().isOk)
        .andExpect(jsonPath("\$.id").value(1))
        .andExpect(jsonPath("\$.name").value("Kotlin"))
        .andDo(print())
  }
}
