package com.ixto.lernplan_fsdev.api;

import com.ixto.lernplan_fsdev.api.dto.FootballTeamCreateModel;
import com.ixto.lernplan_fsdev.api.dto.FootballTeamReadModel;
import com.ixto.lernplan_fsdev.api.dto.FootballTeamUpdateModel;
import com.ixto.lernplan_fsdev.api.dto.Greeting;
import com.ixto.lernplan_fsdev.domain.persistence.FootballTeamEntity;
import com.ixto.lernplan_fsdev.api.services.FootballTeamService;
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
 * Rest controller demonstrating a more complicated separation of user input to database layer with map struct
 */
@RestController
@RequestMapping(value = "/footballteam")
public class FootballTeamController {

    @Autowired
    private static final FootballTeamMapper MAPPER = Mappers.getMapper(FootballTeamMapper.class);

    @Autowired
    FootballTeamService footballTeamEntityService;

    @GetMapping("/greeting")
    public Greeting greeting(
        @RequestParam(value = "name", defaultValue = "World") String name
    ) {
        String greetingTemplate = "Hello, %s!";
        return new Greeting(UUID.randomUUID(), String.format(greetingTemplate, name));
    }

    @PostMapping(
        value = "",
        produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FootballTeamReadModel> createFootballTeamEntity(
        @RequestBody FootballTeamCreateModel footballTeamCreateModel
    ) {
        FootballTeamEntity footballTeam = footballTeamEntityService.save(footballTeamCreateModel);
        FootballTeamReadModel footballTeamReadable = MAPPER.toReadModel(footballTeam);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(footballTeamReadable);
    }

    @PutMapping(
        value = "",
        produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FootballTeamReadModel> updateFootballTeamEntity(
        @RequestBody FootballTeamUpdateModel footballTeamUpdateModel
    ) {
        FootballTeamEntity footballTeam = footballTeamEntityService.save(footballTeamUpdateModel);
        FootballTeamReadModel footballTeamReadable = MAPPER.toReadModel(footballTeam);

        return ResponseEntity
            .ok()
            .body(footballTeamReadable);
    }

    @DeleteMapping(
        value = "/{id}",
        produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(
        @PathVariable UUID id
    ) {
        footballTeamEntityService.deleteById(id);
    }

    @GetMapping(
        value = "",
        produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<FootballTeamReadModel>> getFootballTeam(
        @RequestParam(name = "footballTeamName", required = false)
        final String footballTeamName
    ) {
        List<FootballTeamEntity> footballTeams;

        if (footballTeamName != null) {
            footballTeams = footballTeamEntityService.findByName(footballTeamName);
        } else {
            footballTeams = footballTeamEntityService.findAll();
        }

        List<FootballTeamReadModel> footballTeamsReadable = footballTeams.stream()
            .map(MAPPER::toReadModel)
            .collect(Collectors.toList());

        return ResponseEntity
            .ok()
            .body(footballTeamsReadable);
    }

    @GetMapping(
        value = "/{id}",
        produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FootballTeamReadModel> getFootballTeam(
        @PathVariable UUID id
    ) {
        FootballTeamEntity footballTeam = footballTeamEntityService.findById(id);
        FootballTeamReadModel footballTeamsReadable = MAPPER.toReadModel(footballTeam);

        return ResponseEntity
            .ok()
            .body(footballTeamsReadable);
    }
}
