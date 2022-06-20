package com.ixto.lernplan_fsdev.api.dto;

import com.ixto.lernplan_fsdev.domain.persistence.FootballTeamEntity;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.NonNull;
import lombok.Value;

/**
 * Basic model to create a {@link FootballTeamEntity}
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
@Value
public class FootballTeamCreateModel {

  @ApiModelProperty(required = true, example = "Test Team")
  @NotNull
  @NonNull
  String name;

  @ApiModelProperty(required = true, example = "8")
  @NotNull
  @NonNull
  Integer rating;

}
