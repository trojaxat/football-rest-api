package com.ixto.lernplan_fsdev.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name="NOTES")
public class NotesEntity {
    @Id
    private UUID id;

    @Column(name = "body")
    private String body;

    public NotesEntity() {
    }

    public NotesEntity(UUID id, String body) {
        this.id = id;
        this.body = body;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
