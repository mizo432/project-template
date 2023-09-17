package template.modules.project.domain.model.definationofend.attribute;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import template.shared.type.description.Description;
import template.shared.value.Value;

/**
 * 完了の定義を示す.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "create")
public class DefinitionOfEndAttribute implements Value {

    protected final Description description;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isPresent() {
        return Value.super.isPresent();
    }

}
