package com.undecided.projectTemplate.infra.remoting.electronicComponent;

import com.undecided.projectTemplate.model.electronicComponent.ElectronicComponent;
import com.undecided.projectTemplate.model.electronicComponent.ElectronicComponentRepository;
import com.undecided.projectTemplate.model.electronicComponent.ElectronicComponentType;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class ElectronicComponentRemoting implements ElectronicComponentRepository {

    @Override
    public Optional<ElectronicComponent> findByValueAndType(double v,
        ElectronicComponentType resistor) {
        return Optional.empty();
    }

    @Override
    public ElectronicComponent save(ElectronicComponent resistor) {
        return null;
    }
}
