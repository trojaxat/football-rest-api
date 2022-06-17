package com.ixto.lernplan_fsdev.api.services;

import com.ixto.lernplan_fsdev.api.dto.FootballTeamCreateModel;
import com.ixto.lernplan_fsdev.api.dto.FootballTeamUpdateModel;
import com.ixto.lernplan_fsdev.domain.FootballTeamEntityRepository;
import com.ixto.lernplan_fsdev.domain.persistence.FootballMatchEntity;
import com.ixto.lernplan_fsdev.domain.persistence.FootballTeamEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
@Slf4j
@Service
public class FootballTeamServiceImpl implements FootballTeamService {

  @Autowired
  FootballTeamEntityRepository footballTeamEntityRepo;

  public List<FootballTeamEntity> findByName(String name) {
    return footballTeamEntityRepo.findByName(name);
  }

  public FootballTeamEntity findById(UUID id) {
    return footballTeamEntityRepo.findById(id).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity nicht gefunden!")
    );
  }

  public void deleteById(UUID id) {
    footballTeamEntityRepo.findById(id).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity nicht gefunden!")
    );
    footballTeamEntityRepo.deleteById(id);
  }

  public List<FootballTeamEntity> findAll() {
    return footballTeamEntityRepo.findAll();
  }

  public FootballTeamEntity save(FootballTeamCreateModel footballTeamCreateModel) {
    FootballTeamEntity footballTeam = new FootballTeamEntity(
        UUID.randomUUID(),
        footballTeamCreateModel.getName(),
        footballTeamCreateModel.getRating(),
        new ArrayList<FootballMatchEntity>()
    );

    return footballTeamEntityRepo.save(footballTeam);
  }

  public FootballTeamEntity save(FootballTeamUpdateModel footballTeamUpdateModel) {
    UUID id = footballTeamUpdateModel.getId();
    FootballTeamEntity footballTeam = footballTeamEntityRepo.findById(id).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity nicht gefunden!")
    );

    footballTeam.setName(footballTeamUpdateModel.getName());
    footballTeam.setRating(footballTeamUpdateModel.getRating());

    return footballTeamEntityRepo.save(footballTeam);
  }

}
