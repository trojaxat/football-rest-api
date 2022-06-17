package com.ixto.lernplan_fsdev.api.dto;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

/**
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
@Value
public class FootballTeamUpdateModel {

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
