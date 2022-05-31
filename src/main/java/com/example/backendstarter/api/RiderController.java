package com.example.backendstarter.api;

import com.example.backendstarter.dto.RiderRequest;
import com.example.backendstarter.dto.RiderResponse;
import com.example.backendstarter.dto.TeamResponse;
import com.example.backendstarter.entity.Rider;
import com.example.backendstarter.entity.Team;
import com.example.backendstarter.repositories.RiderRepository;
import com.example.backendstarter.repositories.TeamRepository;
import com.example.backendstarter.service.RiderService;
import com.example.backendstarter.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/riders")
public class RiderController {

    RiderService riderService;
    TeamService teamService;

    public RiderController(RiderService riderService, TeamService teamService) {
        this.riderService = riderService;
        this.teamService = teamService;
    }

    @GetMapping
    public List<RiderResponse> getRiders(@RequestParam(value = "team", required = false)String teamName){
        return riderService.getRiders(teamName);
    }

    @GetMapping("/{id}")
    public RiderResponse getRider(@PathVariable int id) {
        return riderService.getRider(id);
    }

    @PostMapping
    public RiderResponse addRider(@RequestBody RiderRequest body){
        return riderService.addRider(body);
    }

    @PutMapping("/{id}")
    public RiderResponse editRider(@RequestBody RiderRequest body, @PathVariable int id){
        return riderService.editRider(body, id);
    }

    @DeleteMapping("/{id}")
    public void deleteRider(@PathVariable int id){
        riderService.deleteRider(id);
    }


}
