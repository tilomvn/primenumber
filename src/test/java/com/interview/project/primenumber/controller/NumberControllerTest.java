package com.interview.project.primenumber.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.project.primenumber.services.NumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NumberService numberService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testGetHighestPrimeNumberReturnPrimeNumber() throws Exception {
        Integer primeNumResult = 53;
        when(numberService.getHighestPrimeNumber(anyInt())).thenReturn(primeNumResult);

        MvcResult mvcResult = mockMvc.perform(get("/number/primenumber/55"))
                .andExpect(status().isOk()).andReturn();

        Map<String, Integer> response = mapper.readValue(mvcResult.getResponse().getContentAsString(), Map.class);
        assertEquals(primeNumResult, response.get("prime_number"));
    }

    @Test
    void testGetHighestPrimeNumberReturnHaifu1ByValidInput() throws Exception {
        Integer primeNumResult = -1;
        when(numberService.getHighestPrimeNumber(anyInt())).thenReturn(primeNumResult);

        int validInput = 2;
        MvcResult mvcResult = mockMvc.perform(get("/number/primenumber/" + validInput))
                .andExpect(status().isOk()).andReturn();

        Map<String, Integer> response = mapper.readValue(mvcResult.getResponse().getContentAsString(), Map.class);
        assertEquals(primeNumResult, response.get("prime_number"));
    }

    @Test
    void testGetHighestPrimeNumberReturnHaifu1ByInValidInput() throws Exception {
        Integer primeNumResult = -1;
        when(numberService.getHighestPrimeNumber(anyInt())).thenReturn(primeNumResult);

        String invalidInput = "2E";
        MvcResult mvcResult = mockMvc.perform(get("/number/primenumber/" + invalidInput))
                .andExpect(status().isBadRequest()).andReturn();

        Map<String, Integer> response = mapper.readValue(mvcResult.getResponse().getContentAsString(), Map.class);
        assertEquals(primeNumResult, response.get("prime_number"));
    }
}
