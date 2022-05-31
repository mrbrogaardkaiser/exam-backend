package com.example.backendstarter.dto;


import com.example.backendstarter.entity.Rider;
import com.example.backendstarter.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeamResponse {
    private int id;
    private String name;
    private long totalTeamTime;


    public TeamResponse(Team team){
        this.id= team.getId();
        this.name= team.getName();
        this.totalTeamTime=team.getTotalTeamTime();
    }
}
