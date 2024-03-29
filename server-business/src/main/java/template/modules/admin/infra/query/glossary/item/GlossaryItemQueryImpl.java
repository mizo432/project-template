package template.modules.admin.infra.query.glossary.item;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import template.modules.admin.appl.query.glossary.GlossaryItemQuery;
import template.modules.admin.domain.model.glossary.GlossaryItem;
import template.modules.admin.domain.model.glossary.GlossaryItem.Glossary;
import template.modules.admin.domain.model.glossary.GlossaryItemRepository;
import template.shared.entity.id.SnowflakeId;

@Service
@AllArgsConstructor
@SuppressWarnings("PMD")
public class GlossaryItemQueryImpl implements GlossaryItemQuery {

    private final GlossaryItemRepository glossaryRepository;

    /**
     * 全権検索
     *
     * @return 用語辞書
     */
    @Override
    public @NotNull Glossary selectAll() {
        return Glossary.reconstruct(glossaryRepository.selectAll());

    }

    @Override
    public GlossaryItem findOneById(final SnowflakeId glossaryItemId) {
        return glossaryRepository.findOneById(glossaryItemId);

    }
}
