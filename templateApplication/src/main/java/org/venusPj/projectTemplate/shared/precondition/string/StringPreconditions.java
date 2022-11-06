package org.venusPj.projectTemplate.shared.precondition.string;

import org.jetbrains.annotations.NotNull;
import org.venusPj.projectTemplate.shared.precondition.object.ObjectPreconditions;
import org.venusPj.projectTemplate.shared.primitive.string.Strings2;

public class StringPreconditions {

    public static void checkNotEmpty(@NotNull String reference, @NotNull String label) {
        if (Strings2.isEmpty(label)) {
            throw new IllegalArgumentException(
                "引数のlabelが空白です。引数のlabelに空白は許容されません。");
        }

        ObjectPreconditions.checkNotNull(reference, label);
        if (Strings2.isEmpty(reference)) {
            throw new IllegalArgumentException(
                label + "が空白です。" + label + "に空白は許容されません。");
        }

    }
}
