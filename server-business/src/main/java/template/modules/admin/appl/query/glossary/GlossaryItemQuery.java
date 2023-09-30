package template.modules.admin.appl.query.glossary;

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
     * @param GlossaryItemId 擁護辞書アイテムID
     * @return 用語辞書アイテム
     */
    GlossaryItem findOneById(SnowflakeId GlossaryItemId);

}
