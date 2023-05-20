package com.undecided.projectTemplate.shared.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.primitive.object.Objects2;

import java.time.LocalDateTime;

/**
 * 日時の値オブジェクトの基底クラス
 */
public abstract class AbstractDateTimeValue extends AbstractValue<LocalDateTime> implements
        DateTimeValue {

    /**
     * 値
     */
    protected final LocalDateTime value;

    /**
     * コンストラクター
     *
     * @param value 値
     */
    protected AbstractDateTimeValue(LocalDateTime value) {
        this.value = value;
    }

    /**
     * コンストラクター
     */
    protected AbstractDateTimeValue() {
        value = null;
    }

    @Override
    public LocalDateTime getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (Objects2.isNull(value)) {
            return null;
        }
        return value.toString();
    }

    @Override
    public String asString() {
        if (Objects2.isNull(value)) {
            return null;
        }
        return value.toString();

    }

    @JsonIgnore
    public boolean isEmpty() {
        return Objects2.isNull(value);

    }
}
