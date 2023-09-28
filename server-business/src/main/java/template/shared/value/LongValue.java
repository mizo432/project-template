package template.shared.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.primitive.object.Objects2;

/**
 * Longちインターフェイス
 */
public interface LongValue extends SingleValue<Long> {

    /**
     * 文字列表現を取得
     *
     * @return 文字列
     */
    String asString();

    /**
     * 空オブジェクト化判定する
     *
     * @return 空オブジェクトの場合trueを返す
     */
    @JsonIgnore
    default boolean isEmpty() {
        return Objects2.isNull(getValue());

    }

}


