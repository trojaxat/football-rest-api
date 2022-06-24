package com.ixto.lernplan_fsdev.api.dto;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

/**
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FootballMatchUpdateModel {
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
