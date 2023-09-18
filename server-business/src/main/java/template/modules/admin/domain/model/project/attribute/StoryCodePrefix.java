package template.modules.admin.domain.model.project.attribute;

import com.undecided.projectTemplate.shared.precondition.string.StringPreconditions;
import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

/**
 * ストリーコードプレフィックス
 */
@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class StoryCodePrefix extends AbstractStringValue {

    private static final StoryCodePrefix EMPTY = new StoryCodePrefix();

    /**
     * コンストラクター
     *
     * @param value 値
     */
    /* default */StoryCodePrefix(final String value) {
        super(value);
    }

    /**
     * コンストラクター
     */
    public StoryCodePrefix() {

    }

    /**
     * nullオブジェクト取得
     *
     * @return ストーリーコードプレフィックス
     */
    public static StoryCodePrefix empty() {
        return EMPTY;
    }


    /**
     * ファクトリーメソッド
     *
     * @param value 値
     * @return ストーリーコードプレフィックス
     */
    public static StoryCodePrefix of(final String value) {
        StringPreconditions.checkNotEmpty(value, "ストーリーコードの接頭子");
        return new StoryCodePrefix(value);

    }

    /**
     * 再生成メソッド
     *
     * @param value 値
     * @return ストーリーコードプレフィックス
     */
    public static StoryCodePrefix reconstruct(final String value) {
        return new StoryCodePrefix(value);

    }
}
