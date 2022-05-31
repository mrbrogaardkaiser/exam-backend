package com.example.backendstarter.api;

import com.example.backendstarter.entity.Rider;
import com.example.backendstarter.repositories.RiderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest
@Transactional
class RiderControllerTest {

    @Autowired
    RiderRepository riderRepository;
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static Rider riderx;
    private static Rider ridery;

    @BeforeAll
    public static void setUp(@Autowired RiderRepository riderRepository){
        Rider rd = new Rider();
        rd.setName("Alexey Lutsenko");
        Rider re = new Rider();
        re.setName("Miguel Ángel López");
        riderx=riderRepository.save(rd);
        ridery=riderRepository.save(re);
    }

    @Test
    void testGetRider() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/riders/"+riderx.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(riderx.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(riderx.getName()));
    }
}