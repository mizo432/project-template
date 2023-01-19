package com.undecided.projectTemplate.shared.responsibility.layer;

import com.undecided.projectTemplate.shared.responsibility.Responsibility;
import com.undecided.projectTemplate.shared.value.name.Name;

public enum LayerType {
    PRESENTATION_LAYER(Name.of("プレゼンテーション層"), Responsibility.of("")),
    APPLICATION_LAYER(Name.of("アプリケーション層"), Responsibility.of("")),
    MODEL_LAYER(Name.of("モデル層"), Responsibility.of("")),
    INFRASTRUCTURE(Name.of("インフラ層"), Responsibility.of(""));

    private final Responsibility responsibility;
    private final Name layerTypename;

    LayerType(Name layerTypeName, Responsibility layerResponsibility) {
        this.layerTypename = layerTypeName;
        this.responsibility = layerResponsibility;
    }

    public Name getLayerTypename() {
        return layerTypename;
    }

    public Responsibility getResponsibility() {
        return responsibility;
    }
}
