package com.undecided.projectTemplate.business.command;

import com.undecided.projectTemplate.business.exception.NotCompatibleViewException;
import com.undecided.projectTemplate.model.electronicComponent.ElectronicComponent;
import com.undecided.projectTemplate.model.electronicComponent.ElectronicComponentFactory;
import com.undecided.projectTemplate.model.electronicComponent.ElectronicComponentRepository;
import com.undecided.projectTemplate.model.electronicComponent.ElectronicComponentType;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResistorComponentService {

    private final ElectronicComponentRepository repository;

    public ResistorComponentService(ElectronicComponentRepository repository) {
        this.repository = repository;
    }

    public ElectronicComponent save(Node labelValue) {

        String datum;

        // Although of same method name - getText - they're different by encapsulated implementation
        if (labelValue instanceof TextField) {
            datum = ((TextField) labelValue).getText();
        } else if (labelValue instanceof Label) {
            datum = ((Label) labelValue).getText();
        } else {
            throw new NotCompatibleViewException();
        }

        double v = Double.parseDouble(datum);

        Optional<ElectronicComponent> electronicComponentOpt = repository.findByValueAndType(v,
            ElectronicComponentType.RESISTOR);

        return electronicComponentOpt.orElseGet(
            () -> repository.save(ElectronicComponentFactory.resistor(v)));
    }
}
