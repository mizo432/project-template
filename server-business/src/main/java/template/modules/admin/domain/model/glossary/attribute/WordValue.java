package template.modules.admin.domain.model.glossary.attribute;

import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

/**
 * 用語
 */
@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class WordValue extends AbstractStringValue {
    private static final WordValue EMPTY_VALUE = new WordValue();

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
     * 空オブジェクト作成
     *
     * @return 用語
     */
    public static WordValue empty() {
        return EMPTY_VALUE;

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
