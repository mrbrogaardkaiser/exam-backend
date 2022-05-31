package com.example.backendstarter.service;

import com.example.backendstarter.dto.TeamResponse;
import com.example.backendstarter.entity.Team;
import com.example.backendstarter.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamResponse> getTeams(){
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(team->new TeamResponse(team)).collect(Collectors.toList());
    }
}
