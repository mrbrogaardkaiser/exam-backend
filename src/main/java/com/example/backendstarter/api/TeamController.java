package com.example.backendstarter.api;


import com.example.backendstarter.dto.TeamResponse;
import com.example.backendstarter.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/teams")
public class TeamController {

    TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<TeamResponse> getTeams(){
        return teamService.getTeams();
    }

    @GetMapping("/{id}")
    TeamResponse getTeam(@PathVariable int id){
        return teamService.getTeam(id);
    }
}
