package com.ixto.lernplan_fsdev.api.services;

import com.ixto.lernplan_fsdev.api.dto.NotesDTO;
import com.ixto.lernplan_fsdev.domain.NotesEntityRepository;
import com.ixto.lernplan_fsdev.domain.persistence.NotesEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

/**
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
@Slf4j
@Service
public class NotesServiceImpl implements NotesService {

  @Autowired
  NotesEntityRepository notesEntityRepository;;
  
  public List<NotesEntity> findByBody(String body) {
    return notesEntityRepository.findByBody(body);
  }

  public NotesEntity findById(UUID id) {
    return notesEntityRepository.findById(id).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity nicht gefunden!")
    );
  }

  public void deleteById(UUID id) {
    notesEntityRepository.findById(id).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity nicht gefunden!")
    );
    notesEntityRepository.deleteById(id);
  }

  public List<NotesEntity> findAll() {
    return notesEntityRepository.findAll();
  }

  public NotesEntity save(NotesDTO notesDTO) {
    UUID id;
    NotesEntity note;

    if (notesDTO.getId() != null) {
      id = notesDTO.getId();
      note = notesEntityRepository.findById(id).orElseThrow(
          () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity nicht gefunden!")
      );

      note.setBody(notesDTO.getBody());
    } else {
      id = UUID.randomUUID();
      note = new NotesEntity(
          id,
          notesDTO.getBody()
      );
    }

    return notesEntityRepository.save(note);
  }

}
