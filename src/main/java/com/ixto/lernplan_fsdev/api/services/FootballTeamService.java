package com.ixto.lernplan_fsdev.api.services;

import com.ixto.lernplan_fsdev.api.dto.FootballTeamCreateModel;
import com.ixto.lernplan_fsdev.api.dto.FootballTeamUpdateModel;
import com.ixto.lernplan_fsdev.domain.persistence.FootballTeamEntity;

import java.util.List;
import java.util.UUID;

public interface FootballTeamService {

  List<FootballTeamEntity> findByName(String name);

  FootballTeamEntity findById(UUID id);

  void deleteById(UUID id);

  List<FootballTeamEntity> findAll();

  FootballTeamEntity save(FootballTeamCreateModel footballTeamDTO);

  FootballTeamEntity save(FootballTeamUpdateModel footballTeamDTO);

}
