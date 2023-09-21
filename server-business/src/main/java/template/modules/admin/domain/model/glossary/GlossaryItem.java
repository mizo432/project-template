package template.modules.admin.domain.model.glossary;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.boot.ConfigAutowireable;
import template.modules.admin.domain.model.glossary.attribute.GlossaryItemAttribute;
import template.shared.entity.id.SnowflakeId;
import template.shared.value.AbstractListValue;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;

/**
 * 用語辞書の1アイテム
 */
@Getter
@Entity(immutable = true)
@Table(schema = "admin", name = "glossary_item")
@ConfigAutowireable
@ToString
@EqualsAndHashCode
public class GlossaryItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "glossary_item_id")
    private final SnowflakeId glossaryItemId;

    private final GlossaryItemAttribute attribute;

    /**
     * コンストラクター
     */
    public GlossaryItem() {
        glossaryItemId = SnowflakeId.EMPTY_VALUE;
        attribute = GlossaryItemAttribute.EMPTY_VALUE;

    }

    /**
     * コンストラクター
     *
     * @param glossaryItemId 用語辞書アイテムID
     * @param attribute      用語辞書アイテム属性
     */
    /* default */GlossaryItem(final SnowflakeId glossaryItemId, final GlossaryItemAttribute attribute) {
        this.glossaryItemId = glossaryItemId;
        this.attribute = attribute;

    }

    /**
     * ファクトリーメソッド
     *
     * @param word        用語
     * @param kanaWord    かな用語
     * @param description 詳細
     * @return 用語辞書即成
     */
    public static GlossaryItem create(final String word, final String kanaWord, final String description) {
        return create(GlossaryItemAttribute.create(word, kanaWord, description));

    }

    /**
     * ファクトリーメソッド
     *
     * @param attribute 用語辞書アイテム属性
     * @return 用語辞書即成
     */
    public static GlossaryItem create(final GlossaryItemAttribute attribute) {
        return create(SnowflakeId.newInstance(), attribute);
    }

    /**
     * ファクトリーメソッド
     *
     * @param glossaryItemId 用語辞書アイテムID
     * @param attribute      用語辞書アイテム属性
     * @return 用語辞書即成
     */
    public static GlossaryItem create(final Long glossaryItemId, final GlossaryItemAttribute attribute) {
        return create(SnowflakeId.of(glossaryItemId), attribute);
    }

    /**
     * ファクトリーメソッド
     *
     * @param glossaryItemId 用語辞書アイテムID
     * @param attribute      用語辞書アイテム属性
     * @return 用語辞書即成
     */
    private static GlossaryItem create(final SnowflakeId glossaryItemId, final GlossaryItemAttribute attribute) {
        return new GlossaryItem(glossaryItemId, attribute);
    }

    /**
     * 用語辞書
     */
    public static class Glossary extends AbstractListValue<GlossaryItem> {

        /**
         * コンストラクター
         *
         * @param value 値
         */
        /* default */Glossary(@NotNull final Collection<GlossaryItem> value) {
            super(value);
        }

        /**
         * 再生成
         *
         * @param value 値
         * @return 用語辞書
         */
        public static @NotNull Glossary reconstruct(@NotNull final Collection<GlossaryItem> value) {
            return new Glossary(value);

        }

        @Override
        public String asString() {
            return toString();

        }
    }

}
