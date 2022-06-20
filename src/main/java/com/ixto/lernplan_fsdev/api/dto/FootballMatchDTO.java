package com.ixto.lernplan_fsdev.api.dto;

import com.ixto.lernplan_fsdev.domain.persistence.FootballMatchEntity;
import com.ixto.lernplan_fsdev.domain.persistence.FootballTeamEntity;

import java.util.List;
import java.util.UUID;

/**
 * Basic DTO for the {@link FootballMatchEntity}
 */
public class FootballMatchDTO {
    private final UUID id;
    private final List<FootballTeamEntity> teams;
    private final String result;

    public FootballMatchDTO(UUID id,  List<FootballTeamEntity> teams, String result) {
        this.id = id;
        this.teams = teams;
        this.result = result;
    }

    public UUID getId() { return id; }

    public List<FootballTeamEntity> getTeams() {
        return teams;
    }

    public String getResult() {
        return result;
    }
}
