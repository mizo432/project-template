package template.modules.admin.appl.query.glossary.item;

import org.jetbrains.annotations.NotNull;
import template.modules.admin.domain.model.glossary.GlossaryItem;
import template.modules.admin.domain.model.glossary.GlossaryItem.Glossary;
import template.shared.entity.id.SnowflakeId;

public interface GlossaryItemQuery {
    /**
     * 全権検索
     *
     * @return 用語辞書
     */
    @NotNull Glossary selectAll();

    /**
     * 擁護辞書アイテムをキーに用語辞書アイテムを検索する
     *
     * @param glossaryItemId 擁護辞書アイテムID
     * @return 用語辞書アイテム
     */
    GlossaryItem findOneById(SnowflakeId glossaryItemId);

}
