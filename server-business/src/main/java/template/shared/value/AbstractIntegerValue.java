package template.shared.value;

import com.undecided.primitive.object.Objects2;

/**
 * Long型を保持する値オブジェクトの基底クラス
 */
public abstract class AbstractIntegerValue extends AbstractValue<Integer> implements IntegerValue {

    /**
     * 保持している値
     */
    private final Integer value;

    /**
     * コンストラクター
     *
     * @param value 値
     */
    protected AbstractIntegerValue(Integer value) {
        this.value = value;

    }

    /**
     * コンストラクター
     */
    protected AbstractIntegerValue() {
        value = null;

    }

    public Integer getValue() {
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


}
