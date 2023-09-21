package template.modules.admin.infra.query.glossary;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import template.modules.admin.appl.query.glossary.GlossaryItemQuery;
import template.modules.admin.domain.model.glossary.GlossaryItem.Glossary;
import template.modules.admin.domain.model.glossary.GlossaryItemRepository;

@Service
@AllArgsConstructor
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
}
