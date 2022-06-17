package com.ixto.lernplan_fsdev.api.services;

import com.ixto.lernplan_fsdev.api.dto.FootballMatchDTO;
import com.ixto.lernplan_fsdev.domain.FootballMatchEntityRepository;
import com.ixto.lernplan_fsdev.domain.persistence.FootballMatchEntity;
import com.ixto.lernplan_fsdev.domain.persistence.FootballTeamEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

/**
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
@Slf4j
@Service
public class FootballMatchServiceImpl implements FootballMatchService {

  @Autowired
  FootballMatchEntityRepository FootballMatchEntityRepo;

  @Autowired
  FootballTeamService footballTeamService;

  public List<FootballMatchEntity> findByTeamName(String teamName) throws Exception {
    List<FootballTeamEntity> team = footballTeamService.findByName(teamName);

    if (team.size() == 0) {
      throw new Exception("Team not found");
    } else if (team.size() > 1) {
      throw new Exception("Multiple teams with same name found error");
    }

    return FootballMatchEntityRepo.findByTeams(team.get(0));
  }

  public FootballMatchEntity findById(UUID id) {
    return FootballMatchEntityRepo.findById(id).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity nicht gefunden!")
    );
  }

  public void deleteById(UUID id) {
    FootballMatchEntityRepo.findById(id).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity nicht gefunden!")
    );
    FootballMatchEntityRepo.deleteById(id);
  }

  public List<FootballMatchEntity> findAll() {
    return FootballMatchEntityRepo.findAll();
  }

  public FootballMatchEntity save(FootballMatchDTO footballMatchDTO) {

    UUID id;
    FootballMatchEntity footballMatch;

    if (footballMatchDTO.getId() != null) {
      id = footballMatchDTO.getId();
      footballMatch = FootballMatchEntityRepo.findById(id).orElseThrow(
          () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity nicht gefunden!")
      );

      footballMatch.setTeams(footballMatchDTO.getTeams());
      footballMatch.setResult(footballMatchDTO.getResult());
    } else {
      id = UUID.randomUUID();
      footballMatch = new FootballMatchEntity(
          id,
          footballMatchDTO.getTeams(),
          footballMatchDTO.getResult()
      );
    }

    return FootballMatchEntityRepo.save(footballMatch);
  }

}
