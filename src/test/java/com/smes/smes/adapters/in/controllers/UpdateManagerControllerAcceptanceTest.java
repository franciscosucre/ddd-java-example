package com.smes.smes.adapters.in.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smes.smes.helpers.test_types.AbstractBaseIntegrationTest;
import com.smes.smes.adapters.in.controllers.update_manager_controller.UpdateManagerControllerBodyDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@DirtiesContext
@AutoConfigureMockMvc
public class UpdateManagerControllerAcceptanceTest  extends AbstractBaseIntegrationTest {

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldUpdateOnlyTheManagerName() throws Exception {
        String url = String.format("/managers/%s", "6b2b6fef-2e33-4adc-a892-27657f960848");

        UpdateManagerControllerBodyDto dto = new UpdateManagerControllerBodyDto(
                "test name",
                null
        );
        String json = mapper.writeValueAsString(dto);


        MvcResult response = mockMvc.perform(
                        MockMvcRequestBuilders.patch(url).contentType(MediaType.APPLICATION_JSON).content(json)
                )
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }

    @Test
    void shouldUpdateOnlyTheManagerEmail() throws Exception {
        String url = String.format("/managers/%s", "6b2b6fef-2e33-4adc-a892-27657f960848");

        UpdateManagerControllerBodyDto dto = new UpdateManagerControllerBodyDto(
                null,
                "test@test.io"
        );
        String json = mapper.writeValueAsString(dto);


        MvcResult response = mockMvc.perform(
                        MockMvcRequestBuilders.patch(url).contentType(MediaType.APPLICATION_JSON).content(json)
                )
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }

    @Test
    void shouldUpdateOnlyTheManager() throws Exception {
        String url = String.format("/managers/%s", "6b2b6fef-2e33-4adc-a892-27657f960848");

        UpdateManagerControllerBodyDto dto = new UpdateManagerControllerBodyDto(
                "new name",
                "test@test.io"
        );
        String json = mapper.writeValueAsString(dto);


        MvcResult response = mockMvc.perform(
                        MockMvcRequestBuilders.patch(url).contentType(MediaType.APPLICATION_JSON).content(json)
                )
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }

}
