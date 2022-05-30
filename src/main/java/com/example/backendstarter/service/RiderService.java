package com.example.backendstarter.service;

import com.example.backendstarter.dto.RiderRequest;
import com.example.backendstarter.dto.RiderResponse;
import com.example.backendstarter.entity.Rider;
import com.example.backendstarter.error.Client4xxException;
import com.example.backendstarter.repositories.RiderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RiderService {
    RiderRepository riderRepository;

    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    public List<RiderResponse> getRiders(String teamName){
        List<Rider> riders;
        if(teamName!=null){
            riders = riderRepository.findRiderByTeam_Name(teamName);
        } else
            riders = riderRepository.findAll();
        return riders.stream().map(rider->new RiderResponse(rider)).collect(Collectors.toList());
    }

    public RiderResponse getRider(int id) {
        Rider rider = riderRepository.findById(id).orElseThrow(()->new Client4xxException("No rider with that id"));
        return new RiderResponse(rider);
    }

    public RiderResponse addRider(RiderRequest body){
        Rider newRider = riderRepository.save(new Rider(body));
        return new RiderResponse(newRider);}

    public RiderResponse editRider(RiderRequest body, int id){
        Rider rider = riderRepository.findById(id).orElseThrow(()->new Client4xxException("No rider with that id"));
        rider.setName(body.getName());
        rider.setNation(body.getNation());
        rider.setDateOfBirth(body.getDateOfBirth());
        rider.setClimberPoints(body.getClimberPoints());
        rider.setSprintPoint(body.getSprintPoint());
        rider.setTimeInSeconds(body.getTimeInSeconds());
        riderRepository.save(rider);
        return new RiderResponse(rider);
    }

    public void deleteRider(int id){
        if(!riderRepository.existsById(id)){
            throw new Client4xxException("No rider with that id");
        }
        riderRepository.deleteById(id);
    }






}
