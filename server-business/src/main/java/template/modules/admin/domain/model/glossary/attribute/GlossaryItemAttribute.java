package template.modules.admin.domain.model.glossary.attribute;

import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Column;
import org.seasar.doma.Embeddable;
import template.shared.type.description.Description;
import template.shared.value.Value;

/**
 * 用語集アイテムの属性
 */
@Getter
@Embeddable
@ToString
public class GlossaryItemAttribute implements Value {
    private final static GlossaryItemAttribute EMPTY = new GlossaryItemAttribute();

    @Column(name = "word")
    private final Word word;
    @Column(name = "kana_word")
    private final KanaWord kanaWord;
    @Column(name = "description")
    private final Description description;

    /* default */GlossaryItemAttribute(final Word word,
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
        this.word = Word.empty();
        this.kanaWord = KanaWord.empty();
        this.description = Description.empty();

    }

    public static GlossaryItemAttribute empty() {
        return EMPTY;
    }

    public static GlossaryItemAttribute create(final String word, final String kanaWord, final String description) {
        return create(Word.of(word), KanaWord.of(kanaWord), Description.of(description));
    }

    private static GlossaryItemAttribute create(final Word word, final KanaWord kanaWord, final Description description) {
        return new GlossaryItemAttribute(word, kanaWord, description);
    }

    @Override
    public boolean isEmpty() {
        return EMPTY.equals(this);
    }
}
