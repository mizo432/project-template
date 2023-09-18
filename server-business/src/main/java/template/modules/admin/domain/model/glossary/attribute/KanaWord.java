package template.modules.admin.domain.model.glossary.attribute;

import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

/**
 * 用語読み
 */
@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class KanaWord extends AbstractStringValue {
    private static final KanaWord EMPTY = new KanaWord();

    /**
     * コンストラクター
     *
     * @param value 値
     */
    /* default */KanaWord(final String value) {
        super(value);
    }

    /**
     * コンストラクター
     */
    public KanaWord() {
        super();

    }

    /**
     * 空オブジェクト生成
     *
     * @return 用語読み
     */
    public static KanaWord empty() {
        return EMPTY;

    }

    /**
     * 再生成
     *
     * @param value 値
     * @return 用語読み
     */
    public static KanaWord reconstruct(final String value) {
        return new KanaWord(value);
    }

    /**
     * ファクトリーメソッド
     *
     * @param value 値
     * @return 用語読み
     */
    public static KanaWord of(final String value) {
        return new KanaWord(value);
    }
}
