package org.venusPj.projectTemplate.modules.resource.domain.story.attribute;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.value.StringValue;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class Description implements
    StringValue<Description> {

    private final String value;

    public static Description reconstruct(String value) {
        return new Description(value);

    }

    @Override
    public String asString() {
        return value;
    }

}
