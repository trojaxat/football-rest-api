package com.ixto.lernplan_fsdev.api;

import com.ixto.lernplan_fsdev.api.dto.FootballTeamCreateModel;
import com.ixto.lernplan_fsdev.api.dto.FootballTeamDTO;
import com.ixto.lernplan_fsdev.api.dto.FootballTeamReadModel;
import com.ixto.lernplan_fsdev.api.dto.FootballTeamUpdateModel;
import com.ixto.lernplan_fsdev.domain.persistence.FootballTeamChanges;
import com.ixto.lernplan_fsdev.domain.persistence.FootballTeamCreate;
import com.ixto.lernplan_fsdev.domain.persistence.FootballTeamEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * The mapper relating to {@link FootballTeamEntity}
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
@Mapper
public interface FootballTeamMapper {

    FootballTeamReadModel toEntity(FootballTeamEntity footballTeam);

    List<FootballTeamReadModel> toEntities(List<FootballTeamEntity> footballTeam);

    FootballTeamReadModel toDomain(FootballTeamDTO footballTeam);

    FootballTeamCreate toCreate(FootballTeamCreateModel model);

    FootballTeamChanges toChanges(FootballTeamUpdateModel model);

}

