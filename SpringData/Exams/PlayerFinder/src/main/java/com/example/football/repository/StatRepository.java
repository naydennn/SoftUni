package com.example.football.repository;

import com.example.football.models.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatRepository extends JpaRepository<Stat, Long> {

    Stat findByPassingAndEnduranceAndShooting(Double passing, Double endurance, Double shooting);
}
