package com.undecided.projectTemplate.modules.example.usecase.employee;


public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }

}
