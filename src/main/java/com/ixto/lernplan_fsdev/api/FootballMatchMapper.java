package com.ixto.lernplan_fsdev.api;

import com.ixto.lernplan_fsdev.api.dto.*;
import com.ixto.lernplan_fsdev.domain.persistence.FootballMatchEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

/**
 * The mapper relating to {@link FootballMatchEntity}
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
@Mapper(uses = { FootballTeamMapper.class })
interface FootballMatchMapper {
  FootballTeamMapper MAPPER = Mappers.getMapper(FootballTeamMapper.class);

  @Mapping(target = "teams", expression = "java(MAPPER.toEntities(footballTeam.getTeams()))")
  FootballMatchReadModel toReadModel(FootballMatchEntity footballTeam);

  FootballMatchDTO toDomain(FootballMatchCreateModel footballTeamCreateModel);

  FootballMatchDTO toDomain(FootballMatchUpdateModel FootballTeamUpdateModel);

}
