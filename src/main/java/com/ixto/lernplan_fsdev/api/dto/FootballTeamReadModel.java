package com.ixto.lernplan_fsdev.api.dto;

import com.ixto.lernplan_fsdev.domain.persistence.FootballTeamEntity;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.UUID;

/**
 * Basic model to read the {@link FootballTeamEntity}
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FootballTeamReadModel {

  @ApiModelProperty(required = true, example = "Test Team")
  @NotNull
  @NonNull
  String name;

  @ApiModelProperty(required = true, example = "8")
  @NotNull
  @NonNull
  Integer rating;

  @ApiModelProperty(required = true, example = "8d9339a0-a278-4ee1-a2a4-d366d83d6f16")
  @NonNull
  UUID id;

}
