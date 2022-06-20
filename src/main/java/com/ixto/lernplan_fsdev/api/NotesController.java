package com.ixto.lernplan_fsdev.api;

import com.ixto.lernplan_fsdev.api.dto.NotesDTO;
import com.ixto.lernplan_fsdev.api.services.NotesService;
import com.ixto.lernplan_fsdev.domain.persistence.NotesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Rest controller demonstrating a simple database transfer object style with service layer
 */
@RestController
public class NotesController {

    @Autowired
    NotesService noteService;

    @GetMapping(
        value = "/notes",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<NotesEntity> getAll(
        @RequestParam(
            name = "body",
            required = false
        ) String body
    ) {
        if (body != null) {
            return noteService.findByBody(body);
        } else {
            return noteService.findAll();
        }
    }

    @GetMapping(
        value = "/notes/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<NotesEntity> getNoteById(
        @PathVariable(value = "id") UUID noteId
    ) {
        NotesEntity note = noteService.findById(noteId);

        return ResponseEntity.ok()
            .body(note);
    }

    @PostMapping(
        value = "/notes",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<NotesEntity> createNote(
        @RequestBody NotesDTO notesDTO
    ) {
        return ResponseEntity.ok()
            .body(noteService.save(notesDTO));
    }

    @DeleteMapping(
        value = "/notes/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteNoteById(
        @PathVariable(value = "id") UUID noteId
    ) {
        noteService.deleteById(noteId);

        return ResponseEntity.noContent().build();
    }

}