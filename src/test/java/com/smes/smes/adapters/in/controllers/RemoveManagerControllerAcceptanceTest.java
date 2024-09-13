package com.smes.smes.adapters.in.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smes.smes.AbstractBaseIntegrationTest;
import com.smes.smes.adapters.in.controllers.create_manager_controller.CreateManagerControllerBodyDto;
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

@SpringBootTest
@AutoConfigureMockMvc
public class RemoveManagerControllerAcceptanceTest  extends AbstractBaseIntegrationTest {

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldRemoveTheManager() throws Exception {
        String url = String.format("/managers/%s", "6b2b6fef-2e33-4adc-a892-27657f960848");
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.delete(url))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }

}
