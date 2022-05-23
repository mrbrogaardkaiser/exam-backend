package com.example.backendstarter.repositories;

import com.example.backendstarter.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
}
