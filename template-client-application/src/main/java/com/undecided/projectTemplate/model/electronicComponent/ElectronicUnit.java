package com.undecided.projectTemplate.model.electronicComponent;

import lombok.Getter;

@Getter
public enum ElectronicUnit {

    OHM("Ω"), FARAD("F"), HENRY("H");

    private final String ending;


    ElectronicUnit(String ending) {
        this.ending = ending;
    }
}
