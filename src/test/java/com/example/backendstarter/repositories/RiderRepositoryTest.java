package com.example.backendstarter.repositories;

import com.example.backendstarter.entity.Rider;
import com.example.backendstarter.entity.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RiderRepositoryTest {

    @Autowired
    RiderRepository riderRepository;

    @Autowired
    TeamRepository teamRepository;

    @BeforeEach
    void setUp() {
        riderRepository.deleteAll();
        teamRepository.deleteAll();
        Team t1 = new Team("Alpecin-Deceuninck");
        Rider r1 = new Rider("Gianni Vermeersch","Belgium", LocalDate.of(1992,11,19), 11300L,3,3,t1);
        Rider r2 = new Rider("Xandro Meurisse","Belgium", LocalDate.of(1992,1,31), 11600L,2,2,t1);
        teamRepository.save(t1);
        riderRepository.save(r1);
        riderRepository.save(r2);
    }

    @Test
    public void getRiders(){
        List<Rider> riders = riderRepository.findAll();
        assertEquals(2, riders.size());
    }

    @Test
    public void getRidersFromTeamName(){
        List<Rider> riders = riderRepository.findRiderByTeam_Name("Alpecin-Deceuninck");
        assertEquals(2, riders.size());
    }
}