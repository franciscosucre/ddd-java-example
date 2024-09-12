package com.smes.smes.adapters.in.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smes.smes.adapters.in.controllers.create_manager_controller.CreateManagerControllerBodyDto;
import org.assertj.core.internal.Arrays;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.DriverManager;
import java.util.ArrayList;

@SpringBootTest
@AutoConfigureMockMvc
public class CreateManagerControllerAcceptanceTest {

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateTheManager() throws Exception {
        CreateManagerControllerBodyDto dto = new CreateManagerControllerBodyDto(
                "test name",
                "test@cobee.io"
        );
        String json = mapper.writeValueAsString(dto);

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/managers").contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }

    @Test
    void shouldThrowAnErrorForInvalidEmail() throws Exception {
        CreateManagerControllerBodyDto dto = new CreateManagerControllerBodyDto(
                "test name",
                "invalid-email"
        );
        String json = mapper.writeValueAsString(dto);

        mockMvc.perform(MockMvcRequestBuilders.post("/managers").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().is(422))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[0].field").value("email"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[0].message").value("must be a well-formed email address"))
                .andReturn();
    }
}
