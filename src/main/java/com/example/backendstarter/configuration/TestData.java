package com.example.backendstarter.configuration;

import com.example.backendstarter.entity.Rider;
import com.example.backendstarter.entity.Team;
import com.example.backendstarter.repositories.RiderRepository;
import com.example.backendstarter.repositories.TeamRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;



import java.time.Duration;
import java.time.LocalDate;


@Controller
public class TestData implements ApplicationRunner {
    RiderRepository riderRepository;
    TeamRepository teamRepository;

    public TestData(RiderRepository riderRepository, TeamRepository teamRepository) {
        this.riderRepository = riderRepository;
        this.teamRepository = teamRepository;
    }

    public void makeData(){

        Team t1 = new Team("Alpecin-Deceuninck");
        Team t2 = new Team("Lotto Soudal");
        Team t3 = new Team("Astana Qazaqstan Team");
        Team t4 = new Team("Team DSM");

        Rider r1 = new Rider("Gianni Vermeersch","Belgium", LocalDate.of(1992,11,19), 11300L,3,3,t1);
        Rider r2 = new Rider("Xandro Meurisse","Belgium", LocalDate.of(1992,1,31), 11600L,2,2,t1);
        Rider r3 = new Rider("Tim Merlier","Belgium", LocalDate.of(1992,10,30), 12300L,1,1,t1);
        Rider r4 = new Rider("Mathieu van der Poel","Holland", LocalDate.of(1995,1,19), 16600L,0,0,t1);

        Rider r5 = new Rider("Brent Van Moer","Belgium", LocalDate.of(1998,1,12), 11600L,1,0,t2);
        Rider r6 = new Rider("Tim Wellens","Belgium", LocalDate.of(1991,5,10), 17600L,0,0,t2);
        Rider r7 = new Rider("Philippe Gilbert","Holland", LocalDate.of(1982,7,5), 16400L,4,2,t2);
        Rider r8 = new Rider("Caleb Ewan","Australia", LocalDate.of(1994,6,11), 16000L,0,0,t2);


        teamRepository.save(t1);
        teamRepository.save(t2);



    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        makeData();

    }
}
