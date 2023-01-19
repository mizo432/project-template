package com.undecided.projectTemplate.model.electronicCalculation;


import com.undecided.projectTemplate.model.electronicComponent.ElectronicComponent;
import com.undecided.projectTemplate.model.electronicComponent.ElectronicComponentType;
import java.util.List;
import lombok.Data;

@Data
public class ElectronicCalculation {

    private Long id;

    private List<ElectronicComponent> components;

    private ElectronicComponent result;

    private CalculationMode mode;

    private ElectronicComponentType type;
}
