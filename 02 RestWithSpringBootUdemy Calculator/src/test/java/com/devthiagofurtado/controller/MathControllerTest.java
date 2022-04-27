package com.devthiagofurtado.controller;

import com.devthiagofurtado.service.MathService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class MathControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private MathController mathController;

    @Mock
    private MathService mathService;

    @Autowired
    private ObjectMapper mapper;

    private static String A = "1,0";
    private static String B = "2,0";

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
    }

    @Test
    void sum() throws Exception {

        mockMvc.perform(get("/sum/"+A+"/"+B)).andExpect(status().isOk());
    }

    @Test
    void sub() throws Exception {

        mockMvc.perform(get("/sub/"+A+"/"+B)).andExpect(status().isOk());
    }

    @Test
    void div() throws Exception {

        mockMvc.perform(get("/div/"+A+"/"+B)).andExpect(status().isOk());
    }

    @Test
    void mul() throws Exception {

        mockMvc.perform(get("/mul/"+A+"/"+B)).andExpect(status().isOk());
    }

    @Test
    void med() throws Exception {

        mockMvc.perform(get("/med/"+A+"/"+B)).andExpect(status().isOk());
    }

    @Test
    void raiz() throws Exception {

        mockMvc.perform(get("/raiz/"+A)).andExpect(status().isOk());
    }
}