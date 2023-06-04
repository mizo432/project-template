package com.undecided.projectTemplate.modules.project.domain.model.definationOfEnd.attribute;

import com.undecided.projectTemplate.shared.type.description.Description;
import com.undecided.projectTemplate.shared.value.Value;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

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
