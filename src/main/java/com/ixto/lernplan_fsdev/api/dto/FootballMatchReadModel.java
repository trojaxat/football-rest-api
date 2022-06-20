package com.ixto.lernplan_fsdev.api.dto;

import com.ixto.lernplan_fsdev.domain.persistence.FootballMatchEntity;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.NonNull;
import lombok.Value;

import java.util.List;
import java.util.UUID;

/**
 * Basic model to read the {@link FootballMatchEntity}
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
@Value
public class FootballMatchReadModel {
  @ApiModelProperty(required = true, example = "8d9339a0-a278-4ee1-a2a4-d366d83d6f16")
  @NonNull
  UUID id;

  @ApiModelProperty(required = true)
  @NonNull
  List<FootballTeamReadModel> teams;

  @ApiModelProperty(required = true, example = "2:1")
  @NotNull
  @NonNull
  String result;
}
