package com.ixto.lernplan_fsdev.domain.persistence;

import lombok.Builder;
import lombok.Value;

/**
 * Changes class for {@link FootballTeamEntity} in case we extend the pattern to separate
 * the business layer, from the database layer, with the conceptual layer
 *
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
@Value
@Builder(toBuilder = true)
public class FootballTeamChanges {
  String name;

  Integer rating;
}
