package template.modules.admin.appl.query.glossary;

import org.jetbrains.annotations.NotNull;
import template.modules.admin.domain.model.glossary.GlossaryItem.Glossary;

public interface GlossaryItemQuery {
    /**
     * 全権検索
     *
     * @return 用語辞書
     */
    @NotNull Glossary selectAll();
}
