package com.smes.smes.domain.exceptions;

import java.util.UUID;

public class ManagerNotFoundException extends Exception{
    public ManagerNotFoundException(UUID managerId) {
        super(String.format("Manager with id  '%s' not found", managerId.toString()));
    }
}
