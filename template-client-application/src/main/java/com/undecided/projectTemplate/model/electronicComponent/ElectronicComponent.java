package com.undecided.projectTemplate.model.electronicComponent;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"id"})
public class ElectronicComponent {

    private Long id;

    private Double value;

    private ElectronicComponentType type;
}
