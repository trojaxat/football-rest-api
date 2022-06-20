package com.ixto.lernplan_fsdev.domain;

import com.ixto.lernplan_fsdev.domain.persistence.FootballMatchEntity;
import com.ixto.lernplan_fsdev.domain.persistence.FootballTeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Repository for {@link FootballMatchEntity}
 *
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
public interface FootballMatchEntityRepository extends JpaRepository<FootballMatchEntity, UUID> {
    List<FootballMatchEntity> findByTeams(FootballTeamEntity footballTeam);
}
