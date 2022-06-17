package com.ixto.lernplan_fsdev.api;

import com.ixto.lernplan_fsdev.api.dto.FootballMatchDTO;
import com.ixto.lernplan_fsdev.api.dto.FootballMatchReadModel;
import com.ixto.lernplan_fsdev.domain.persistence.FootballMatchEntity;
import com.ixto.lernplan_fsdev.api.services.FootballMatchService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Rest controller for a simple database transfer object style with service layer and sub entities
 */
@RestController
@RequestMapping(value = "/footballmatch")
public class FootballMatchController {

    @Autowired
    private static final FootballMatchMapper MAPPER = Mappers.getMapper(FootballMatchMapper.class);

    @Autowired
    FootballMatchService footballMatchEntityService;

    @PostMapping(
        value = "",
        produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FootballMatchReadModel> createFootballMatchEntity(
        @RequestBody FootballMatchDTO footballMatchDTO
    ) {
        FootballMatchEntity footballMatch = footballMatchEntityService.save(footballMatchDTO);
        FootballMatchReadModel footballMatchReadable = MAPPER.toReadModel(footballMatch);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(footballMatchReadable);
    }

    @PutMapping(
        value = "",
        produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FootballMatchReadModel> updateFootballMatchEntity(
        @RequestBody FootballMatchDTO footballMatchDTO
    ) {
        FootballMatchEntity footballMatch = footballMatchEntityService.save(footballMatchDTO);
        FootballMatchReadModel footballMatchReadable = MAPPER.toReadModel(footballMatch);

        return ResponseEntity
            .ok()
            .body(footballMatchReadable);
    }

    @DeleteMapping(
        value = "/{id}",
        produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(
        @PathVariable UUID id
    ) {
        footballMatchEntityService.deleteById(id);
    }

    @GetMapping(
        value = "",
        produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<FootballMatchReadModel>> getFootballMatch(
        @RequestParam(name = "footballTeamName", required = false)
        final String footballTeamName
    ) throws Exception {
        List<FootballMatchEntity> footballMatches;

        if (footballTeamName != null) {
            footballMatches = footballMatchEntityService.findByTeamName(footballTeamName);
        } else {
            footballMatches = footballMatchEntityService.findAll();
        }

        List<FootballMatchReadModel> footballMatchesReadable = footballMatches.stream()
            .map(MAPPER::toReadModel)
            .collect(Collectors.toList());

        return ResponseEntity
            .ok()
            .body(footballMatchesReadable);
    }

    @GetMapping(
        value = "/{id}",
        produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FootballMatchReadModel> getFootballMatch(
        @PathVariable UUID id
    ) {
        FootballMatchEntity footballMatch = footballMatchEntityService.findById(id);
        FootballMatchReadModel footballMatchReadable = MAPPER.toReadModel(footballMatch);

        return ResponseEntity
            .ok()
            .body(footballMatchReadable);
    }
}
