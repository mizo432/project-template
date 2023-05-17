package com.undecided.projectTemplate.model.electronicCalculation;

import java.util.List;

public interface ElectronicCalculationRepository {

    void deleteById(Long id);

    List<ElectronicCalculation> findAll();

    void save(ElectronicCalculation electronicCalculation);
}
