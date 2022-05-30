package com.example.backendstarter.service;

import com.example.backendstarter.dto.RiderResponse;
import com.example.backendstarter.entity.Rider;
import com.example.backendstarter.entity.Team;
import com.example.backendstarter.repositories.RiderRepository;
import com.example.backendstarter.repositories.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class RiderServiceTest {

    @Autowired
    RiderRepository riderRepository;
    @Autowired
    TeamRepository teamRepository;

    RiderService riderService;

    @BeforeEach
    void setUp() {
        Team t2 = new Team("Lotto Soudal");
        teamRepository.save(t2);
        Rider r5 = new Rider("Brent Van Moer","Belgium", LocalDate.of(1998,1,12), 11600L,1,0,t2);
        Rider r6 = new Rider("Tim Wellens","Belgium", LocalDate.of(1991,5,10), 17600L,0,0,t2);
        riderRepository.save(r5);
        riderRepository.save(r6);
        riderService = new RiderService(riderRepository);
    }

    @Test
    void getRiders(){
        List<RiderResponse> riders = riderService.getRiders("Lotto Soudal");
        assertEquals(2, riders.size());
        assertInstanceOf(RiderResponse.class, riders.get(0));
        assertThat(riders, containsInAnyOrder(hasProperty("name", is("Brent Van Moer")), hasProperty("nation", is("Belgium"))));

    }
}