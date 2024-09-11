package com.smes.smes.domain.entities;

import java.util.UUID;

public class Manager {
    public final UUID id;
    public final String name;
    public final String email;

    public Manager(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
