package template.modules.admin.appl.command.glossary.item;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.modules.admin.domain.model.glossary.GlossaryItemRepository;
import template.shared.entity.id.SnowflakeId;

/**
 * 擁護辞書アイテム削除コマンド
 */
@Service
@AllArgsConstructor
public class DropItemCommand {
    private final GlossaryItemRepository glossaryItemRepository;

    /**
     * 擁護辞書アイテムを更新する
     *
     * @param glossaryItemId 擁護辞書アイテムID
     */
    @Transactional
    public void execute(final SnowflakeId glossaryItemId) {
        glossaryItemRepository.deleteById(glossaryItemId);
    }

}
