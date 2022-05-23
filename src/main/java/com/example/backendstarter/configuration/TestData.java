package com.example.backendstarter.configuration;

import com.example.backendstarter.entity.Unit;
import com.example.backendstarter.repositories.UnitRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;


@Controller
public class TestData implements ApplicationRunner {

    UnitRepository unitRepository;

    public TestData(UnitRepository unitRepository){
        this.unitRepository= unitRepository;
    }

    public void makeData(){
        Unit one = new Unit("Test");
        unitRepository.save(one);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //makeData();

    }
}
