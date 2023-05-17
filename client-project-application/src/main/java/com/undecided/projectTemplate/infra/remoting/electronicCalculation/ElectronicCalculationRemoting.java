package com.undecided.projectTemplate.infra.remoting.electronicCalculation;

import com.undecided.projectTemplate.model.electronicCalculation.ElectronicCalculation;
import com.undecided.projectTemplate.model.electronicCalculation.ElectronicCalculationRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ElectronicCalculationRemoting implements ElectronicCalculationRepository {

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<ElectronicCalculation> findAll() {
        return null;
    }

    @Override
    public void save(ElectronicCalculation electronicCalculation) {
        
    }
}
