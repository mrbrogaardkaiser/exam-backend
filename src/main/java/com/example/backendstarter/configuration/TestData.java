package com.example.backendstarter.configuration;

import com.example.backendstarter.entity.Rider;
import com.example.backendstarter.entity.Team;
import com.example.backendstarter.repositories.RiderRepository;
import com.example.backendstarter.repositories.TeamRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;



import java.time.Duration;
import java.time.LocalDate;


@Controller
@Profile("!test")
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


        Rider r1 = new Rider("Gianni Vermeersch","Belgium", LocalDate.of(1992,11,19), 11300L,0,20,t1);
        Rider r2 = new Rider("Xandro Meurisse","Belgium", LocalDate.of(1992,1,31), 11600L,3,15,t1);
        Rider r3 = new Rider("Tim Merlier","Belgium", LocalDate.of(1992,10,30), 12300L,1,10,t1);
        Rider r4 = new Rider("Mathieu van der Poel","Holland", LocalDate.of(1995,1,19), 16600L,0,2,t1);

        Rider r5 = new Rider("Brent Van Moer","Belgium", LocalDate.of(1998,1,12), 11600L,1,21,t2);
        Rider r6 = new Rider("Tim Wellens","Belgium", LocalDate.of(1991,5,10), 17600L,0,11,t2);
        Rider r7 = new Rider("Philippe Gilbert","Holland", LocalDate.of(1982,7,5), 16400L,0,4,t2);
        Rider r8 = new Rider("Caleb Ewan","Australia", LocalDate.of(1994,6,11), 16000L,0,0,t2);

        Rider rr = new Rider("Samuele Battistella","Italy", LocalDate.of(1998,11,14), 12000L,1,3,t3);
        Rider rd = new Rider("Alexey Lutsenko","Kazakhstan", LocalDate.of(1992,9,7), 13000L,0,0,t3);
        Rider re = new Rider("Miguel Ángel López","Colombia", LocalDate.of(1994,2,4), 14000L,0,2,t3);
        Rider rs = new Rider("Gianni Moscon","Italy", LocalDate.of(1994,4,20), 15000L,0,1,t3);

        teamRepository.save(t1);
        teamRepository.save(t2);
        teamRepository.save(t3);



    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        makeData();

    }
}
