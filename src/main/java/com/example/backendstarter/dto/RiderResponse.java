package com.example.backendstarter.dto;

import com.example.backendstarter.entity.Rider;
import com.example.backendstarter.entity.Team;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class RiderResponse {
    private int id;
    private String name;
    private String nation;
    private LocalDate dateOfBirth;
    private long timeInSeconds;
    private int climberPoints;
    private int sprintPoint;
    private Team team;

    public RiderResponse(Rider rider){
        this.id=rider.getId();
        this.name=rider.getName();
        this.nation=rider.getNation();
        this.dateOfBirth=rider.getDateOfBirth();
        this.timeInSeconds=rider.getTimeInSeconds();
        this.climberPoints= rider.getClimberPoints();
        this.sprintPoint= rider.getSprintPoint();
        this.team=rider.getTeam();
    }
}
