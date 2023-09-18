package template.modules.admin.domain.model.glossary.attribute;

import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Column;
import org.seasar.doma.Embeddable;
import template.shared.type.description.Description;
import template.shared.value.Value;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用語集アイテムの属性
 */
@Getter
@Embeddable
@ToString
public class GlossaryItemAttribute implements Value, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final static GlossaryItemAttribute EMPTY_VALUE = new GlossaryItemAttribute();

    @Column(name = "word")
    private final WordValue word;
    @Column(name = "kana_word")
    private final KanaWord kanaWord;
    @Column(name = "description")
    private final Description description;

    /**
     * コンストラクター
     *
     * @param word        用語
     * @param kanaWord    用語かな
     * @param description 詳細
     */
    /* default */GlossaryItemAttribute(final WordValue word,
                                       final KanaWord kanaWord,
                                       final Description description) {
        this.word = word;
        this.kanaWord = kanaWord;
        this.description = description;

    }

    /**
     * コンストラクター
     */
    public GlossaryItemAttribute() {
        this.word = WordValue.empty();
        this.kanaWord = KanaWord.empty();
        this.description = Description.empty();

    }

    /**
     * 空オブジェクト取得
     *
     * @return 用語辞書アイテム属性
     */
    public static GlossaryItemAttribute empty() {
        return EMPTY_VALUE;
    }

    /**
     * ファクトリー
     *
     * @param word        用語
     * @param kanaWord    用語かな
     * @param description 詳細
     * @return 用語辞書アイテム属性
     */
    public static GlossaryItemAttribute create(final String word, final String kanaWord, final String description) {
        return create(WordValue.of(word), KanaWord.of(kanaWord), Description.of(description));
    }

    /**
     * ファクトリー
     *
     * @param word        用語
     * @param kanaWord    用語かな
     * @param description 詳細
     * @return 用語辞書アイテム属性
     */
    private static GlossaryItemAttribute create(final WordValue word, final KanaWord kanaWord, final Description description) {
        return new GlossaryItemAttribute(word, kanaWord, description);
    }

    /**
     * 空かどうかを判定する
     *
     * @return 空の場合true
     */
    @Override
    public boolean isEmpty() {
        return EMPTY_VALUE.equals(this);
    }
}
