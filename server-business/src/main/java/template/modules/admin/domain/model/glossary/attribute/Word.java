package template.modules.admin.domain.model.glossary.attribute;

import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

/**
 * 用語
 */
@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class Word extends AbstractStringValue {
    private static final Word EMPTY = new Word();

    /**
     * コンストラクター
     *
     * @param value 値
     */
    Word(final String value) {
        super(value);
    }

    /**
     * コンストラクター
     */
    public Word() {

    }

    /**
     * 空オブジェクト作成
     *
     * @return 用語
     */
    public static Word empty() {
        return EMPTY;

    }

    /**
     * 再生成
     *
     * @param value 値
     * @return 用語
     */
    public static Word reconstruct(final String value) {
        return new Word(value);

    }

    /**
     * ファクトリーメソッド
     *
     * @param value 値
     * @return 用語
     */
    public static Word of(final String value) {
        return new Word(value);

    }
}
