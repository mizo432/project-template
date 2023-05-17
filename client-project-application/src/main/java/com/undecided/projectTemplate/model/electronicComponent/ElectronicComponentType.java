package com.undecided.projectTemplate.model.electronicComponent;

import lombok.Getter;

@Getter
public enum ElectronicComponentType {
    RESISTOR(ElectronicUnit.OHM),
    CAPACITOR(ElectronicUnit.FARAD),
    INDUCTOR(ElectronicUnit.HENRY);

    private final ElectronicUnit unit;

    ElectronicComponentType(ElectronicUnit unit) {
        this.unit = unit;
    }
}
