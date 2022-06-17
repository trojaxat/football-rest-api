package com.ixto.lernplan_fsdev.domain.persistence;

import lombok.Builder;
import lombok.Value;

/**
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
@Value
@Builder(toBuilder = true)
public class FootballTeamCreate {
  String name;

  Integer rating;

}
