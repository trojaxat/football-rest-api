package com.ixto.lernplan_fsdev.api.dto;

import java.util.UUID;

public class Greeting {

    private final UUID id;
    private final String content;

    public Greeting(UUID id, String content) {
        this.id = id;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
