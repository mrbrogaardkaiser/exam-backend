package com.example.backendstarter.repositories;

import com.example.backendstarter.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
