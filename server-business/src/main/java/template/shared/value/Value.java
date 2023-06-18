package template.shared.value;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 値オブジェクトのインターフェイス
 */
public interface Value {

    /**
     * 値が空かを返却する
     *
     * @return 値が空の場合<code>true</code>を返却する
     */
    boolean isEmpty();

    @JsonIgnore
    default boolean isPresent() {
        return !isEmpty();
    }
}
