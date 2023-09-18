package template.modules.admin.domain.model.glossary;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.boot.ConfigAutowireable;
import template.modules.admin.domain.model.glossary.attribute.GlossaryItemAttribute;
import template.shared.entity.id.SnowflakeId;

/**
 * 用語辞書の1アイテム
 */
@Getter
@Entity(immutable = true)
@Table(schema = "admin", name = "glossary_item")
@ConfigAutowireable
@ToString
@EqualsAndHashCode
public class GlossaryItem {

    @Id
    @Column(name = "glossary_item_id")
    private final SnowflakeId glossaryItemId;

    private final GlossaryItemAttribute glossaryItemAttribute;

    /**
     * コンストラクター
     */
    public GlossaryItem() {
        glossaryItemId = SnowflakeId.empty();
        glossaryItemAttribute = GlossaryItemAttribute.empty();

    }

    /**
     * コンストラクター
     *
     * @param glossaryItemId        用語辞書アイテムID
     * @param glossaryItemAttribute 用語辞書アイテム属性
     */
    GlossaryItem(SnowflakeId glossaryItemId, GlossaryItemAttribute glossaryItemAttribute) {
        this.glossaryItemId = glossaryItemId;
        this.glossaryItemAttribute = glossaryItemAttribute;

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
     * @param glossaryItemAttribute 用語辞書アイテム属性
     * @return 用語辞書即成
     */
    private static GlossaryItem create(final GlossaryItemAttribute glossaryItemAttribute) {
        return new GlossaryItem(SnowflakeId.newInstance(), glossaryItemAttribute);
    }
}
