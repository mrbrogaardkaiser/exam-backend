package com.example.backendstarter.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;

@Getter
@Setter
public class RiderRequest {
    private int id;
    private String name;
    private String nation;
    private LocalDate dateOfBirth;
    private long timeInSeconds;
    private int climberPoints;
    private int sprintPoint;

}
