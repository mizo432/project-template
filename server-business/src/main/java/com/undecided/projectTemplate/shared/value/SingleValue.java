package com.undecided.projectTemplate.shared.value;

public interface SingleValue<T> extends Value {

    /**
     * 保持している値を参照する
     *
     * @return 値
     */
    T getValue();

    /**
     * 保持している値を文字列表現にする
     *
     * @return 保持している値の文字列表現
     */
    String asString();

    boolean isEmpty();

}
