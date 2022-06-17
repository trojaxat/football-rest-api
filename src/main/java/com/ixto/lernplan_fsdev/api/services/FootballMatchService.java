package com.ixto.lernplan_fsdev.api.services;

import com.ixto.lernplan_fsdev.api.dto.FootballMatchDTO;
import com.ixto.lernplan_fsdev.domain.persistence.FootballMatchEntity;

import java.util.List;
import java.util.UUID;

public interface FootballMatchService {

  List<FootballMatchEntity> findByTeamName(String team) throws Exception;

  FootballMatchEntity findById(UUID id);

  void deleteById(UUID id);

  List<FootballMatchEntity> findAll();

  FootballMatchEntity save(FootballMatchDTO footballMatchDTO);

}
