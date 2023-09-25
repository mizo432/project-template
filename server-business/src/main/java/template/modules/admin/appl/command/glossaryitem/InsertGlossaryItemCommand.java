package template.modules.admin.appl.command.glossaryitem;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.modules.admin.domain.model.glossary.GlossaryItem;
import template.modules.admin.domain.model.glossary.GlossaryItemRepository;

/**
 * 祝日登録コマンドサービス.
 */
@Service
@AllArgsConstructor
public class InsertGlossaryItemCommand {

    private final GlossaryItemRepository glossaryItemRepository;

    /**
     * 祝日登録を実行する
     *
     * @param glossaryItem 擁護辞書アイテム
     */
    @Transactional
    public void execute(@NonNull final GlossaryItem glossaryItem) {
        glossaryItemRepository.insert(glossaryItem);

    }
}
