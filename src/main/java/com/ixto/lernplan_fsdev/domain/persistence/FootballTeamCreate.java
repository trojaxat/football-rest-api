package com.ixto.lernplan_fsdev.domain.persistence;

import lombok.Builder;
import lombok.Value;

/**
 * Create class for {@link FootballTeamEntity} in case we extend the pattern to separate
 * the business layer, from the database layer, with a domain driven design
 *
 * Application layer - (Users logic, taking user requests and translates into cases for the domain layer)
 * Domain layer - (Business logic, with command query separation principle)
 * Infrastructure layer - (Database logic, saving entities with jpa/hibernate etc)
 *
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
@Value
@Builder(toBuilder = true)
public class FootballTeamCreate {
  String name;

  Integer rating;

}
