package com.undecided.projectTemplate.business.command;

import static com.undecided.projectTemplate.assembler.ResistanceInputElement.RESIS_SELECTOR;

import com.undecided.projectTemplate.model.electronicCalculation.CalculationMode;
import com.undecided.projectTemplate.model.electronicCalculation.ElectronicCalculation;
import com.undecided.projectTemplate.model.electronicCalculation.ElectronicCalculationRepository;
import com.undecided.projectTemplate.model.electronicComponent.ElectronicComponent;
import com.undecided.projectTemplate.model.electronicComponent.ElectronicComponentType;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Service;

@Service
public class ResistanceParallelCalculationService {

    private final ElectronicCalculationRepository repository;

    private final ResistorComponentService resistorComponentService;

    public ResistanceParallelCalculationService(ElectronicCalculationRepository repository,
        ResistorComponentService resistorComponentService) {
        this.repository = repository;
        this.resistorComponentService = resistorComponentService;

    }

    public void register(Node refNode, Node resultNode) {

        Set<Node> rs = refNode.lookupAll(RESIS_SELECTOR);

        ElectronicCalculation electronicCalculation = new ElectronicCalculation();

        ElectronicComponent resultComponent = resistorComponentService.save(resultNode);
        electronicCalculation.setResult(resultComponent);
        List<ElectronicComponent> resistors = rs
            .stream()
            .filter(n -> n instanceof TextField)
            .map(n -> resistorComponentService.save(n))
            .collect(Collectors.toList());

        electronicCalculation.setComponents(resistors);
        electronicCalculation.setMode(CalculationMode.PARALLEL);
        electronicCalculation.setType(ElectronicComponentType.RESISTOR);

        repository.save(electronicCalculation);
    }
}
