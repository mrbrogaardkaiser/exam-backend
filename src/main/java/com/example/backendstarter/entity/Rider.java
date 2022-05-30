package com.example.backendstarter.entity;

import com.example.backendstarter.dto.RiderRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nation;
    private LocalDate dateOfBirth;
    private long timeInSeconds;
    private int climberPoints;
    private int sprintPoint;


    @ManyToOne
    private Team team;
    public void setTeam(Team team){
        this.team=team;
    }

    public Rider(String name, String nation, LocalDate dateOfBirth, Long timeInSeconds, int climberPoints, int sprintPoint, Team team) {
        this.name = name;
        this.nation = nation;
        this.dateOfBirth = dateOfBirth;
        this.timeInSeconds=timeInSeconds;
        this.climberPoints = climberPoints;
        this.sprintPoint = sprintPoint;
        team.addRider(this);
        this.setTeam(team);
    }

    public Rider(RiderRequest body){
        this.name= body.getName();
        this.nation=body.getNation();
        this.dateOfBirth=body.getDateOfBirth();
        this.climberPoints= body.getClimberPoints();
        this.sprintPoint= body.getSprintPoint();
        this.timeInSeconds=body.getTimeInSeconds();
    }
}
