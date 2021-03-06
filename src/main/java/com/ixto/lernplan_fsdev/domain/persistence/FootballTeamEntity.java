package com.ixto.lernplan_fsdev.domain.persistence;

import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Football team is the {@link FootballTeamEntity} which is used for each individual team
 */
@Entity(name="FOOTBALL_TEAMS")
@Builder
public class FootballTeamEntity {
    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private Integer rating;

    @Builder.Default
    @ManyToMany(mappedBy="teams", fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    @Size(max=2)
    private List<FootballMatchEntity> matches = new ArrayList<>();

    public FootballTeamEntity() {
    }

    public FootballTeamEntity(UUID id, String name, Integer rating, List<FootballMatchEntity> matches) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.matches = matches;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FootballMatchEntity> getMatches() {
        return matches;
    }

    public void setMatches(List<FootballMatchEntity> matches) {
        this.matches = matches;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
