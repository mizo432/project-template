package template.modules.admin.domain.model.glossary.attribute;

import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用語
 */
@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class WordValue extends AbstractStringValue implements Serializable {
    /**
     * nullオブジェクト
     */
    public static final WordValue EMPTY_VALUE = new WordValue();
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクター
     *
     * @param value 値
     */
    /* default */WordValue(final String value) {
        super(value);
    }

    /**
     * コンストラクター
     */
    public WordValue() {
        super();

    }

    /**
     * 再生成
     *
     * @param value 値
     * @return 用語
     */
    public static WordValue reconstruct(final String value) {
        return new WordValue(value);

    }

    /**
     * ファクトリーメソッド
     *
     * @param value 値
     * @return 用語
     */
    public static WordValue of(final String value) {
        return new WordValue(value);

    }
}
