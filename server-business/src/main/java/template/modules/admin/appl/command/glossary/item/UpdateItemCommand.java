package template.modules.admin.appl.command.glossary.item;

import lombok.AllArgsConstructor;
import org.seasar.doma.jdbc.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.modules.admin.domain.model.glossary.GlossaryItem;
import template.modules.admin.domain.model.glossary.GlossaryItemRepository;

/**
 * 擁護辞書アイテム更新コマンド
 */
@Service
@AllArgsConstructor
public class UpdateItemCommand {
    private final GlossaryItemRepository glossaryItemRepository;

    /**
     * 擁護辞書アイテムを更新する
     *
     * @param glossaryItem 擁護辞書アイテム
     * @return 更新結果
     */
    @Transactional
    public Result<GlossaryItem> execute(final GlossaryItem glossaryItem) {
        return glossaryItemRepository.update(glossaryItem);

    }

}
