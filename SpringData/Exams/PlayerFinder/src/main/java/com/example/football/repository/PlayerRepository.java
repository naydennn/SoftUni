package com.example.football.repository;


import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findByEmail(String email);

    @Query("select p from Player p where p.birthDate > '1995-01-01' and p.birthDate < '2003-01-01'  order by p.stat.shooting desc, p.stat.passing desc, p.stat.endurance desc, p.lastName")
    List<Player> getBestPlayerOrdered();

}
