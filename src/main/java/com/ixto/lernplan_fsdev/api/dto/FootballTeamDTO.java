package com.ixto.lernplan_fsdev.api.dto;

import java.util.UUID;

public class FootballTeamDTO {
    private final UUID id;
    private final String name;
    private final Integer rating;

    public FootballTeamDTO(UUID id, String name, Integer rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    public UUID getId() { return id; }

    public String getName() {
        return name;
    }

    public Integer getRating() {
        return rating;
    }
}
