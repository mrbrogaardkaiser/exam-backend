package com.example.backendstarter.repositories;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UnitRepositoryTest {
/*
    @Autowired
    UnitRepository unitRepository;

    static int unit1, unit2;

    @BeforeAll
    static void setUp(@Autowired UnitRepository unitRepository) {
        unitRepository.deleteAll();
        unit1 = unitRepository.save(new Unit("test")).getId();
        unit2= unitRepository.save(new Unit("test2")).getId();
    }

    @Test
    void getUnits(){
        List<Unit> units = unitRepository.findAll();
        assertEquals(2, units.size());

    }*/
}