package com.undecided.projectTemplate.shared.responsibility.model;

import com.undecided.projectTemplate.shared.responsibility.Responsibility;
import com.undecided.projectTemplate.shared.value.name.Name;

public enum ModelType {
    MOMENT(Name.of("瞬間"), Responsibility.of("")),
    INTERVAL(Name.of("時間間隔"), Responsibility.of("")),
    PARTY(Name.of("パーティー"), Responsibility.of("")),
    PLACE(Name.of("場所"), Responsibility.of("")),
    THING(Name.of("物"), Responsibility.of("")),
    PARTY_ROLE(Name.of("パーティー役割"), Responsibility.of("")),
    PLACE_ROLE(Name.of("場所役割"), Responsibility.of("")),
    THING_ROLE(Name.of("物役割"), Responsibility.of("")),
    PARTY_DESCRIPTION(Name.of("パーティー詳細"), Responsibility.of("")),
    PLACE_DESCRIPTION(Name.of("場所詳細"), Responsibility.of("")),
    THING_DESCRIPTION(Name.of("物詳細"), Responsibility.of("")),
    COMPUTER(Name.of("計算ロジック"), Responsibility.of(""));

    private final Name modelTypeName;
    private final Responsibility responsibility;

    ModelType(Name modelTypeName, Responsibility responsibility) {
        this.modelTypeName = modelTypeName;
        this.responsibility = responsibility;

    }

    public Name getModelTypeName() {
        return modelTypeName;
    }

    public Responsibility getResponsibility() {
        return responsibility;
    }
}
