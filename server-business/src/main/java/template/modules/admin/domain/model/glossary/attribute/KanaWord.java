package template.modules.admin.domain.model.glossary.attribute;

import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用語読み
 */
@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class KanaWord extends AbstractStringValue implements Serializable {
    /**
     * nullオブジェクト
     */
    public static final KanaWord EMPTY_VALUE = new KanaWord();
    @Serial
    private static final long serialVersionUID = 1L;

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
