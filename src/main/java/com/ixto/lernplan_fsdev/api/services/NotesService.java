package com.ixto.lernplan_fsdev.api.services;

import com.ixto.lernplan_fsdev.api.dto.NotesDTO;
import com.ixto.lernplan_fsdev.domain.persistence.NotesEntity;

import java.util.List;
import java.util.UUID;

/**
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
public interface NotesService {

  List<NotesEntity> findByBody(String body);

  NotesEntity findById(UUID id);

  void deleteById(UUID id);

  List<NotesEntity> findAll();

  NotesEntity save(NotesDTO notesDTO);
}
