package com.ixto.lernplan_fsdev.api.dto;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

/**
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FootballMatchCreateModel {

  @ApiModelProperty(required = true)
  @NonNull
  List<FootballTeamReadModel> teams;

  @ApiModelProperty(required = true, example = "2:1")
  @NotNull
  @NonNull
  String result;
}