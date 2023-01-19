package com.undecided.projectTemplate.model.electronicComponent;

import java.util.Optional;

public interface ElectronicComponentRepository {

    Optional<ElectronicComponent> findByValueAndType(double v, ElectronicComponentType resistor);

    ElectronicComponent save(ElectronicComponent resistor);
    
}
