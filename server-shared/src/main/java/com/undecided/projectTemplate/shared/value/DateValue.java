package com.undecided.projectTemplate.shared.value;

import com.undecided.primitive.object.Objects2;

import java.time.LocalDate;

/**
 * 日付値インターフェイス
 */
public interface DateValue extends SingleValue<LocalDate> {

    default boolean isEmpty() {
        return Objects2.isNull(getValue());

    }

}
