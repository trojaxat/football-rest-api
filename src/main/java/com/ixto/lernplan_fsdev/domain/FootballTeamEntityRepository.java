package com.ixto.lernplan_fsdev.domain;

import com.ixto.lernplan_fsdev.domain.persistence.FootballTeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FootballTeamEntityRepository extends JpaRepository<FootballTeamEntity, UUID> {
    List<FootballTeamEntity> findByName(String name);
    List<FootballTeamEntity> findByRating(Integer rating);
}
