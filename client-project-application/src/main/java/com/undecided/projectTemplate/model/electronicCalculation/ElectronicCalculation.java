package com.undecided.projectTemplate.model.electronicCalculation;


import com.undecided.projectTemplate.model.electronicComponent.ElectronicComponent;
import com.undecided.projectTemplate.model.electronicComponent.ElectronicComponentType;
import lombok.Data;

import java.util.List;

@Data
public class ElectronicCalculation {

    private Long id;

    private List<ElectronicComponent> components;

    private ElectronicComponent result;

    private CalculationMode mode;

    private ElectronicComponentType type;
}
