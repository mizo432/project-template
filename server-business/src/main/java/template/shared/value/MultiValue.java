package template.shared.value;

/**
 * コンポジットな値のインターフェイス
 *
 * @param <T> マルチバリューの方
 */
public interface MultiValue<T extends MultiValue<T>> extends Value {

    /**
     * オブジェクトが空かを返却する
     *
     * @return 空の場合trueを返す
     */
    boolean isEmpty();

}
