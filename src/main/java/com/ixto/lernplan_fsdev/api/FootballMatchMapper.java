package com.ixto.lernplan_fsdev.api;

import com.ixto.lernplan_fsdev.api.dto.FootballMatchReadModel;
import com.ixto.lernplan_fsdev.domain.persistence.FootballMatchEntity;
import org.mapstruct.Mapper;

/**
 * The mapper relating to {@link FootballMatchEntity}
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
@Mapper
interface FootballMatchMapper {
  FootballMatchReadModel toReadModel(FootballMatchEntity footballTeam);
}
