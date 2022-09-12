package org.venusPj.projectTemplate.learning.constructor.constructor;

/**
 * コンストラクターの代わりにファクトリーメソッドを使用する
 */
public class AnyClass {

    private final String value;

    /**
     * Ctrl+[Enter]をコンストラクター上で入力しコンテキストメニューで 「コンストラクターをファクトリーメソッドに置換」を選択する
     * すると、{@link org.venusPj.projectTemplate.learning.constructor.factoryMethod.AnyClass}の様になる。
     *
     * @param value 値
     */
    AnyClass(String value) {
        this.value = value;

    }

    public String getValue() {
        return value;
    }

}
