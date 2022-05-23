package com.example.backendstarter.api;


import com.example.backendstarter.entity.Unit;
import com.example.backendstarter.repositories.UnitRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// test for git
@CrossOrigin
@RestController
@RequestMapping("api/units")
public class UnitController {
    UnitRepository unitRepository;

    public UnitController(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @GetMapping
    public List<Unit> getUnits(){
        List<Unit> units = unitRepository.findAll();
        return units;
    }

}
