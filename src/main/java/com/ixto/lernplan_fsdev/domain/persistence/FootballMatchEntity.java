package com.ixto.lernplan_fsdev.domain.persistence;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity(name="FOOTBALL_MATCHES")
public class FootballMatchEntity {
    @Id
    @Column(name = "teams")
    private UUID id;

    @Column(name = "teams")
    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "matches",
        joinColumns = @JoinColumn(name = "footballteam_id"),
        inverseJoinColumns = @JoinColumn(name = "footballmatch_id")
    )
    private List<FootballTeamEntity> teams = new ArrayList<FootballTeamEntity>();

    @Column(name = "result")
    private String result;

    public FootballMatchEntity() {
    }

    public FootballMatchEntity(UUID id,  List<FootballTeamEntity> teams, String result) {
        this.id = id;
        this.teams = teams;
        this.result = result;
    }

    public UUID getId() {
        return id;
    }

    public List<FootballTeamEntity> getTeams() {
        return teams;
    }

    public void setTeams(List<FootballTeamEntity> teams) {
        this.teams = teams;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
