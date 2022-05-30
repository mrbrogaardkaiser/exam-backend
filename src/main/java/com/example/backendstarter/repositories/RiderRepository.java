package com.example.backendstarter.repositories;

import com.example.backendstarter.entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiderRepository extends JpaRepository<Rider, Integer> {

    List<Rider> findRiderByTeam_Name(String teamName);
}
