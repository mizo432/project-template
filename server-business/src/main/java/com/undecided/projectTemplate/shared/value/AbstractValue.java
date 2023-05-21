package com.undecided.projectTemplate.shared.value;

import com.undecided.primitive.object.Objects2;

/**
 * 値オブジェクトの基底クラス
 *
 * @param <T> 値オブジェクトが保持している要素の型
 */
public abstract class AbstractValue<T> implements SingleValue<T> {


    @Override
    public String toString() {
        if (Objects2.isNull(getValue())) {
            return null;
        }
        return getValue().toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (Objects2.isNull(obj)) {
            return false;
        }
        if (obj.getClass() == getClass()) {
            return Objects2.equal(getValue(), ((AbstractValue<?>) obj).getValue());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects2.hash(getClass(), getValue());

    }

}
