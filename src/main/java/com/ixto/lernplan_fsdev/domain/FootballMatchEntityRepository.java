package com.ixto.lernplan_fsdev.domain;

import com.ixto.lernplan_fsdev.domain.persistence.FootballMatchEntity;
import com.ixto.lernplan_fsdev.domain.persistence.FootballTeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FootballMatchEntityRepository extends JpaRepository<FootballMatchEntity, UUID> {
//    @Query("SELECT o from MyObject o where inventoryId in :ids" )
    List<FootballMatchEntity> findByTeams(FootballTeamEntity footballTeam);
}
