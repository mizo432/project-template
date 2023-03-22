package com.undecided.projectTemplate.business.domain.entity;

public enum EntityType {

    /**
     * 未設定
     */
    UNKNOWN("未設定", ""),
    /**
     * リソース
     */
    RESOURCE("リソース", "R"),
    /**
     * イベント
     */
    EVENT("イベント", "E"),
    /**
     * 多値のOR
     */
    MO("多値のOR", "MO"),
    /**
     * 多値のAND
     */
    MA("多値のAND", "MA"),
    /**
     * みなしエンティティ
     */
    VE("みなしエンティティ", "VE"),

    HDR("ヘッダー", "HEADER"),

    DTL("明細", "DTL"),
    LAPUTA("ラピュタ", ""),
    TURBO("ターボファイル", "TB");

    /**
     * ダイアグラム表示用
     */
    private final String label;

    /**
     * 種類名
     */
    private final String typeName;

    /**
     * コンストラクタ
     *
     * @param label エンティティ種類の表示名
     */
    EntityType(String typeName, String label) {
        this.typeName = typeName;
        this.label = label;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @return the typeName
     */
    public String getTypeName() {
        return typeName;
    }

    public boolean isUnknown() {
        return this == EntityType.UNKNOWN;
    }
}
