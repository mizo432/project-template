package com.undecided.projectTemplate.business.command;

import com.undecided.projectTemplate.model.electronicCalculation.ElectronicCalculationRepository;
import javafx.scene.Node;
import org.springframework.stereotype.Service;

@Service
public class ComponentCalculationService {

    private final ElectronicCalculationRepository repository;

    public ComponentCalculationService(ElectronicCalculationRepository repository) {
        this.repository = repository;
    }

    public void delete(Node node) {
        Long id = Long.valueOf(node.getId());
        repository.deleteById(id);
    }
}
