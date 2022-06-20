package com.ixto.lernplan_fsdev.api.dto;

import java.util.UUID;

/**
 * Basic DTO for the {@link NotesDTO}
 */
public class NotesDTO {
    private final String body;
    private final UUID id;

    public NotesDTO(String body, UUID id) {
      this.body = body;
      this.id = id;
    }

    public String getBody() {
      return body;
    }

    public UUID getId() { return id; }

}
